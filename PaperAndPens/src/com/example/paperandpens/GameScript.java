package com.example.paperandpens;



/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/


//This will do is change the situation of the given choice that the user chooses. 

public class GameScript extends Thread {

	double scene;
	private String sc;
	private String [] choice = new String[4];
	int choose;
	boolean running = true;
	public void setRunning(boolean running)
	{
		this.running = running;
	}
	public GameScript()
	{
		scene = 1.0;
		init();
	}
	public GameScript(double scene)
	{
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
		
	}
	public void setChoices(String [] choice)
	{
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String state = null;
		if(scene == 1.0)
		{
			init();
		}
		while(running)
		{
			/*want to get input*/
			if(getInput(choose) != null)
			{
				state = getInput(choose);
				
			}
			else 
			{
				continue;
			}
			
			
			
		}
	}
	/* this will do setup what the user choices give a new setting*/
	public void obtainChoice(int sit, int c)
	{
		switch(sit)
		{
		/* forest*/
		case 0:
			
			break;
		/*town*/
			
		case 1:
			break;
			
		}
		
		
	}
	
	public void init()
	{
		sc = "You are in the forest, there is a village a few miles away from where you are. There are two path ways, " +
				"one going left and one going straight";
		choice [0] = "Search around your surrounding.\n";
		choice [1] = "Sleep in a creepy yet serene forest. \n";
		choice [2] = "Proceed straight.\n";
		choice [3] = "Take the left turn. \n";
	
		
	}
	
	
	public void gameLoop()
	{
		String state = null;
		while (running)
		{
			
			
		}
		
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
				break;
			case 2:
				decide = choice[1];
				break;
			case 3:
				decide = choice[2];
				break;
			case 4:
				decide = choice[3];
				break;
				
			default:
				decide = null;
			}
			return decide;
	}
	
	public void update(int sit, int c)
	{
		
	}
	
}
