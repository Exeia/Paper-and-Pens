package com.example.paperandpens;
/*
 *Copyright (C) 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

import java.util.ArrayList;
import java.util.Random;

public class BattleSeq extends Thread {

	private String status; 
	BattleData data;
	boolean run, player = true, enemy= false, flee = false;
	int response = 0;
	final int ATTK =1, DEF =2, GTFO = 3, RANGE = 10;
	boolean def;
	Random roll = new Random();
	private int defn; 
	public void running(boolean run)
	{
		this.run = run;
	}
	public BattleSeq(BattleData data)
	{
		this.data = data;
		status = "";
		init();
	}
	public void init()
	{
		run();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		Player pl = data.getPlayer();
		ArrayList<Enemy> en = data.getEn();
		int stat= 0 ;
		while(run)
		{
			//set text indicating that is either character dies or enemy is taken care of.
			if(en.isEmpty())
			{
				status = "";
				stat = 1;
				break;
			}
			else if (pl.getHp() <= 0)
			{
				status = "";
				stat = 2;
				break;
			}
			if(player)
			{
				playerResponse(response, pl, en.get(0));
			}
			else if(enemy)
			{
				
			}
		}
		
	}
	public void respone(int response)
	{
		this.response = response;
	}
	public void playerResponse(int r, Player p, Enemy e )
	{
		switch (r)
		{
		case ATTK:
			attk(p, e);
			break;
		case DEF:
			def(p);
			break;
		case GTFO:
			flee(p);
			break;
		}
	}
	public void EnemyTurn()
	{
		
	}
	public void attk(Player p, Enemy e )
	{
		 int dmg =0, hit ; 
		 int crit = 3;
		 hit = (roll.nextInt(p.getDex()/RANGE) + p.getDex())/ 2;
		 /* critical hit */
		 if(hit >= p.getDex() )
		 {
			 dmg = (p.getStr()/2) * roll.nextInt(crit+1);
			 e.Damaged(dmg);
		 }
		 else if ( hit < p.getDex()-2)
		 {
			 dmg =0;
			 e.Damaged(dmg);
		 }
		 else 
		 {
			 e.Damaged(roll.nextInt(p.getBased()));
		 }
	}
	public void def(Player p)
	{
		setDef(true);
		defn = p.getCon() + roll.nextInt(p.getCon()+10);
		
	}
	public void flee(Player p)
	{
		
	}
	public void setDef(boolean def)
	{
		this.def = def;
		
	}
	public String getStatus()
	{
		return status;
	}
	
	
}
