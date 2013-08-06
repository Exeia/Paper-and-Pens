package com.example.paperandpens;
/*
 *Copyright (C)2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

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
