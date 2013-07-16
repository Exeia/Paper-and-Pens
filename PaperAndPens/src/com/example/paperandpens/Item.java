package com.example.paperandpens;

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
