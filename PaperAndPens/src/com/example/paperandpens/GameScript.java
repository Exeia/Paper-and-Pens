package com.example.paperandpens;

import java.util.ArrayList;

import android.content.Intent;
import android.util.Log;


/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/


//This will do is change the situation of the given choice that the user chooses. 

public class GameScript extends Thread {

	int scene;
	public int size = 4;
	private String sc;
	private String [] choice = new String[size];
	int choose;
	boolean running;
	int SLEEP = 2000;
	int count=0;
	int FOREST = 1, TOWN = 2;
	String TAG = StartGame.class.getSimpleName();
	private Player pl; 
	String pl_res;
	private boolean battle ;
	public BattleData data = null;
	public void setRunning(boolean running)
	{
		this.running = running;
	}
	public GameScript(Player pl)
	{
		super();
		this.pl = pl;
		scene = 1;
		init();
	
	}
	public GameScript(int scene)
	{
		super();
		this.scene = scene;
	}
	
	public String getScene()
	{
		return sc;
	}
	public String[] getChoices()
	{
		return choice;
	}
	public void setScene(String sc)
	{
		this.sc = sc;
	}
	public void setPlayer(Player pl)
	{
		this.pl = pl;
	
	}
	public Player getPlayer()
	{
		return pl;
		
	}
	public int getPlace()
	{
		return scene;
	}
	public void setPlace(int scene)
	{
		this.scene = scene;
	}
	public void setPl_res(String pl_res)
	{
		this.pl_res =  pl.getName()+": "+pl_res;
	}
	public String getPl_res()
	{
		return pl_res;
	}
	
	public void setChoice(String [] choice)
	{
		for(int i=0; i < size; i++)
		{
			this.choice[i] = choice[i];
			
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String state = null;
		
		if(isLoaded())
		{
			init();
		}
		Log.d(TAG,"In game loop...");
		while(running)
		{
			/*want to get input*/
			state = getInput(choose);
			if(state.equals(""))
			{
				continue;
				
			}
			else 
			{
			
				update(scene, state);
				state = "";
			}
			try {
				Thread.sleep(SLEEP); 	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	/* this will do setup what the user choices give a new setting*/
	
	public void init()
	{
		pl_res = pl.getName() + ": ...";
		sc = "You are in the forest, there is a village a few miles away from where you are. There are two path ways, " +
				"one going left and one going straight";
		choice [0] = "Search around.\n";
		choice [1] = "Sleep in a creepy yet serene forest. \n";
		choice [2] = "Proceed straight.\n";
		choice [3] = "Take the left turn. \n";
	
		
	}
	
	public void chose(int i)
	{
		choose = i;
		
	}
	public String getInput(int in)
	{
			String decide = null;
			switch(in)
			{
			case 1:
				decide = choice[0];
				Log.d(TAG,decide);
				break;
			case 2:
				decide = choice[1];
				Log.d(TAG,"choice2");
				break;
			case 3:
				decide = choice[2];
				break;
			case 4:
				decide = choice[3];
				break;
				
			default:
				decide = "";
				
			}
			return decide;
	}
	
	public void update(int sit, String c)
	{
		switch(sit)
		{
		/*forest*/ 
		case 1:
			forest(c);
			break;
		case 2:
			town(c);
			break;
		}
		
	}
	//need to add excalibur face (ﺧ益ﺨ)
	public void forest(String c)
	{
		String [] choice = new String[4];
		if(c.equals("Search around.\n"))
		{
			if(count == 0)
			{
			setPl_res("<Search Around>");
			setScene("You found a sword and potion yay!!!");
			Item sword = new Item("short sword", "It's a plain sword that you can go stabby stabby");
			Item pots = new Item("small potion", "It has heals");
			pl.addtoInventory(sword);
			pl.addtoInventory(pots);
			choice [0] = "Search around.\n";
			choice [1] = "Sleep in a creepy yet serene forest. \n";
			choice [2] = "Proceed straight.\n";
			choice [3] = "Take the left turn. \n";
			setChoice(choice);
			count ++;
			}
			else 
			{
				setPl_res("<Search Around again>");

				setScene("There's nothing else around...");
				choice [0] = "Search around your surrounding.\n";
				choice [1] = "Sleep in a creepy yet serene forest. \n";
				choice [2] = "Proceed straight.\n";
				choice [3] = "Take the left turn. \n";
				setChoice(choice);
				
			}
			
			
		}
		else if (c.equals("Sleep in a creepy yet serene forest. \n"))
		{
			setPl_res("<Eager to sleep in the forest >");

			setScene("You feel rested though you feel like someone or something watching you...");
			choice [0] = "Search around your surrounding.\n";
			choice [1] = "Sleep in a creepy yet serene forest. \n";
			choice [2] = "Proceed straight.\n";
			choice [3] = "Take the left turn. \n";
			setChoice(choice);
			
		}
		
		else if(c.equals("Proceed straight.\n"))
		{
			if(count == 0)
			{
		
			setPl_res("<Move Forward>");
			setScene("You proceeded straight to where the you see a sign \'Beware\' \n");
			choice [0] = "Proceed straight\n";
			choice [1] = "Check Area. \n";
			choice [2] = "-_-.\n";
			choice [3] = " \n";
			count++;
			setChoice(choice);
			}
			else
			{
				/*place battle*/
				setPl_res("<Move Forward>");

				setScene("You see a spirit guarding a treasure \n");
				choice [0] = "Battle on\n";
				choice [1] = "Flee \n";
				choice [2] = "-_-.\n";
				choice [3] = " \n";
				setbattle(true);
				count++;
				setChoice(choice);
			}
		}
		else if (c.equals("Battle on\n"))
		{
				if(data.getEn().isEmpty()|| data == null)
				{
					Enemy spirit = new Enemy("Annoying Spirit","Spirit", 2,2,2,2,100,100);
					ArrayList<Enemy> en = new ArrayList<Enemy>();
					en.add(spirit);
					data = new BattleData(pl, en);
					
					
				}
		}
		else if(c.equals("Take the left turn.\n"))
		{
			setPl_res("<Turn Left>");

			setScene("You found yourself a shortcut to town \n");
			choice [0] = "Proceed straight on.\n";
			choice [1] = "Check Area. \n";
			choice [2] = "-_-.\n";
			choice [3] = " \n";
			count++;
			setChoice(choice);
		}
		else if(c.equals("Proceed straight on.\n"))
		{
			setPl_res("<Proceed to Town>");

			setScene("You have a town");
			choice[0] = "Go to the Inn";
			choice[1] = "Got to Armor/Weapon/Item Shop";
			choice[2] = "Go to the Tavern";
			choice[3] = "Go back to the forest";
			setPlace(TOWN);
		}
		

	}
	public boolean getBattle()
	{
		return battle;
	}
	public void setbattle(boolean battle)
	{
		this.battle = battle;
	}
	public void checkedForestArea(String s, int c)
	{
		
	}
	
	public void town(String ch)
	{
		if(ch.contains("Inn"))
		{
			
		}
		else if(ch.contains("Shop"))
		{
			
		}
		else if(ch.contains("Tavern"))
		{
			
		}
		else if(ch.equals("Go back to the forest"))
		{
			setPlace(TOWN);
		}
	}
	public BattleData getData()
	{
		return data;
	}
	public boolean isLoaded()
	{
		return false;
	}
}
