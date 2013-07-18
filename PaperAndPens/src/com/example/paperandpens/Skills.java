package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
public abstract class Skills {
	String name, desc;
	boolean passive;
	public Skills(String name, String desc, boolean passive,int damage, int status)
	{
		this.name = name;
		this.desc = desc;
		this.passive = passive;
	}
	public String getName()
	{
		return name;
	}
	public String getInfo()
	{
		return desc;
	}
	public boolean isPassive()
	{
		return passive;
	
	}
	public void execute()
	{
		
	}
}
