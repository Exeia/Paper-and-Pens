package com.example.paperandpens;

public class Weapon extends Item{

	private int dmg;
	public Weapon(String name, String desc,int dmg) {
		super(name, desc);
		this.dmg = dmg;
		// TODO Auto-generated constructor stub
	}
	
	public int getDmgInput()
	{
		return dmg;
	}

}
