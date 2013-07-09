package com.example.paperandpens;

public class Player {
	private String na, jo;
	private int str,mag,dex,con,hp,mp;
	public Player(String name, String job, int str, int mag, int dex, int cons, int hp,int mp)
	{
		na = name;
		jo = job;
		this.str = str;
		this.dex = dex;
		this.con = cons;
		this.hp = hp;
		this.mp = mp;
		
	}
	public String getJob()
	{
		return jo;
		
	}
	public String getName()
	{
		return na;
	
	}
	public int getStr()
	{
		return str;
	}
	public int getDex()
	{
		return dex;
	}
	public int getCon()
	{
		return con;
	}
	public int getHp()
	{
		return hp;
	}
	public int getMp()
	{
		return mp;
	}
	public void levelUp()
	{
		
	}
}
