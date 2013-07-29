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
	Button b1,b2,b3,b4;
	String TAG = StartGame.class.getSimpleName();
 
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
		sc = "You are in the forest, there is a village a few miles away from where you are. There are two path ways, " +
				"one going left and one going straight";
		choice [0] = "Search around your surrounding.\n";
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
				Log.d(TAG,"hello");
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
		}
		
	}
	public void forest(String c)
	{
		String [] choice = new String[4];
		int count = 0;
		if(c.equals("Search around your surrounding.\n"))
		{
			if(count == 0)
			{
			setScene("You found a sword and potion yay!!!");
			choice [0] = "Search around your surrounding.\n";
			choice [1] = "Sleep in a creepy yet serene forest. \n";
			choice [2] = "Proceed straight.\n";
			choice [3] = "Take the left turn. \n";
			setChoice(choice);
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
		
	}
	
}
