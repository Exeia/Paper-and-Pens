package com.example.paperandpens;
/*
 *Copyright (C) 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
import java.util.ArrayList;
/* battle system ui*/

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;
public class Battle extends  Activity implements  View.OnClickListener  {
	ArrayList<Enemy> e;
	//this needs a thread...
	Button atk, skills, def, flee;
	TextView status;
	Thread running;
	Player person;
	BattleData data;
	int RANGE = 10;
	BattleSeq battle;
	Random roll = new Random();
	final int ATTACK = 1, DEFEND = 2, FLEE =3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle);
		Intent id = getIntent();
		Bundle bd = id.getExtras();
		data = bd.getParcelable("BD");
		status = (TextView) findViewById(R.id.bStatus);
		atk = (Button) findViewById(R.id.atk);
		def = (Button) findViewById(R.id.def);
		skills = (Button) findViewById(R.id.skill);
		flee = (Button) findViewById(R.id.flee);
		battle = new BattleSeq(data);
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
	
	public void useSkills(Skills s)
	{
		
	}
	public void enemyAtk(Enemy e)
	{
		int dmg =0, hit ; 
		 int crit = 3;
		 hit = (roll.nextInt(e.getDex()/RANGE) + e.getDex())/ 3;
		 /* critical hit */
		 if(hit >= e.getDex() )
		 {
			 dmg = (e.getStr()/2) * roll.nextInt(crit+1);
			 e.Damaged(dmg);
		 }
		 else if ( hit < e.getDex()-2)
		 {
			 dmg =0;
			 e.Damaged(dmg);
		 }
		 else 
		 {
			 e.Damaged(roll.nextInt(e.getBased()));
		 }
		 
		
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.atk:
			battle.respone(ATTACK);
			try {
				Thread.sleep(1000);
				update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case R.id.def:
			battle.respone(DEFEND);
			try {
				Thread.sleep(1000);
				update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.flee:
			battle.respone(FLEE);
			try {
				Thread.sleep(1000);
				update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	public void update()
	{
		if(battle.isFlee())
		{
			
		}
	}
}
