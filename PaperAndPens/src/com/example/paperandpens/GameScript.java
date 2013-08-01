package com.example.paperandpens;

import android.util.Log;
import android.widget.Button;



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
	String TAG = StartGame.class.getSimpleName();
	private Player pl; 
	
	private int [] forestArea;
	enum areas{
		FOREST,
		TOWN
	}
	public void setRunning(boolean running)
	{
		this.running = running;
	}
	public GameScript()
	{
		super();
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
	
			init();
		
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
				areas areas;
				update(areas, state);
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
	
	public void update(areas sit, String c)
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
		String checking;
		if(c.equals("Search around.\n"))
		{
			if(count == 0)
			{
			setScene("You found a sword and potion yay!!!");
			choice [0] = "Search around.\n";
			choice [1] = "Sleep in a creepy yet serene forest. \n";
			choice [2] = "Proceed straight.\n";
			choice [3] = "Take the left turn. \n";
			setChoice(choice);
			count ++;
			}
			else 
			{
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
				setScene("You see a spirit guarding a treasure \n");
				choice [0] = "Battle on\n";
				choice [1] = "Flee \n";
				choice [2] = "-_-.\n";
				choice [3] = " \n";
				count++;
				setChoice(choice);
			}
		}
		else if(c.equals("Take the left turn.\n"))
		{
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
			setScene("You have a town");
			choice[0] = "Go to the Inn";
			choice[1] = "Got to Armor/Weapon/Item Shop";
			choice[2] = "Go to the Tavern";
			choice[3] = "Go back to the forest";
			setScene(TOWN);
		}
		

	}
	public void checkedForestArea(String s, int c)
	{
		
	}
	
	public void town(String ch)
	{
		
	}
}
