package com.example.paperandpens;

public abstract class Skills {
	String name, desc;
	public Skills(String name, String desc)
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
