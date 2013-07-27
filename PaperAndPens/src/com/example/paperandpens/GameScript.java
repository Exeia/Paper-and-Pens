package com.example.paperandpens;



/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/


//This will do is change the situation of the given choice that the user chooses. 

public class GameScript{

	double scene;
	private String sc;
	private String [] choice = new String[4];
	enum states{
		CH1, 
		CH2,CH3,CH4
	}
	public GameScript()
	{
		scene = 1.0;
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
	/* this will do setup what the user choices give a new setting*/
	public void obtainChoice(states st)
	{
		switch(st)
		{
		case CH1:
			break;
		case CH2:
			break;
		case CH3:
			break;
		case CH4:
			break;
		}
		
		
	}
}
