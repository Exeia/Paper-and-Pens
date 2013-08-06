package com.example.paperandpens;
/*
 *Copyright (C)2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

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
