package com.example.paperandpens;
/*
 *Copyright (C)2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in https://github.com/Exeia/Paper-and-Pens/blob/master/License.txt
 *or in the source
 *distribution of this software for license terms.
*/
public  class Skills {
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
	
	public void execute()
	{
		
	}
}
