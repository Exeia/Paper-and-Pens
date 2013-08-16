package com.example.paperandpens;
/*
 *Copyright (C)2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in https://github.com/Exeia/Paper-and-Pens/blob/master/License.txt
 *or in the source
 *distribution of this software for license terms.
*/

import java.util.Random;

public class BattleSeq  {

	private String status; 
	BattleData data;
	boolean run, player = true, enemy= false, flee = false, over = false;
	int response = 0;
	final int ATTK =1, DEF =2, GTFO = 3, RANGE = 10;
	boolean def;
	Random roll = new Random();
	private int defn;
	Player pl;
	Enemy en ;
	public void running(boolean run)
	{
		this.run = run;
	}
	public BattleSeq(Player pl, Enemy en)
	{
		this.pl = pl;
		this.en = en;
		status = "";

	}

		// TODO Auto-generated method stub


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
	public void EnemyTurn(Player p, Enemy en)
	{
		int dmg = 0, hit;
		
		hit = roll.nextInt(RANGE);
		
		if(hit > 10 && (def == false))
		{
			dmg = roll.nextInt(RANGE) + en.getAtk();
			status = en.getName() +" deal "+ dmg +" damage, the " + p.getName() + "has " + p.getHp() + " left";
		}
		else if (hit > 10 && (def == true))
		{
			dmg = (roll.nextInt(RANGE) + en.getAtk()) - defn;
		}
		else
		{
			dmg = 0;
		}
		//setPlayerTurn();
		
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
			 e.setHp(dmg);
			 status = "You deal "+ dmg +" damage, the " + e.getName() + "has " + e.getHp() + " left";
		 }
		 else if ( hit < p.getDex()-2)
		 {
			 dmg =0;
			 e.setHp(dmg);
		 }
		 else 
		 {
			 e.setHp(roll.nextInt(p.getBased()));
		 }
		
	}
	public void def(Player p)
	{
		setDef(true);
		defn = p.getCon() + roll.nextInt(p.getCon()+3);
		setEnemyTurn();
		
	}
	public void flee(Player p)
	{
		int toflee = roll.nextInt(RANGE);
		if(toflee <= RANGE && toflee >= 11)
		{
			status = "(ﺧ益ﺨ) <flees away>";
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flee = true;
		}
		
	}
	public void setDef(boolean def)
	{
		this.def = def;
		
	}
	public String getStatus()
	{
		return status;
	}
	
	public void setEnemyTurn()
	{
		player = false;
	
	}
	public void setPlayerTurn()
	{
		player = true;
	}
	public boolean isFlee()
	{
		return flee;
	}
	public boolean isOver()
	{
		return over;
	}
}
