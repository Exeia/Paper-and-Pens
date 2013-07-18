package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
public class Item {

	private String name, desc;
	
	public Item(String name, String desc)
	{
		this.name = name;
		this.desc = desc;
		
	}
	public String getName()
	{
		return name;
		
	}
	public String getInfo()
	{
		return desc;
	}
}
