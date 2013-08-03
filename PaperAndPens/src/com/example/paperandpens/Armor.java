package com.example.paperandpens;

public class Armor extends Item {

	private int def;
	public Armor(String name, String desc, int def)
	{
		super(name,desc);
		this.def = def;
	}
	
	public int getArmDef()
	{
		return def;
	}
}
