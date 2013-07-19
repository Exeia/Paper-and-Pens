package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;
public class Battle extends Activity {

	ArrayList<Enemy> e;
	//this needs a thread...
	Button atk, skills, def, flee;
	TextView status;
	Thread running;
	Player person;
	int RANGE = 10;
	
	Random roll = new Random();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle);
		status = (TextView) findViewById(R.id.bStatus);
		atk = (Button) findViewById(R.id.atk);
		def = (Button) findViewById(R.id.def);
		skills = (Button) findViewById(R.id.skill);
		flee = (Button) findViewById(R.id.flee);
	}
	
	public void start()
	{
		status.setText("Encounter "+ e.size() + " enemies");
		while(true)
		{
			if(e.isEmpty() || person.getHp()<=0)
			{
				//set text indicating that is either character dies or enemy is taken care of.
				if(e.isEmpty())
				{
					status.setText("All hostiles eliminated \n");
				}
				else
				{
					status.setText("You have died");
				}
				break;
			}
		
			
			
			
		}
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
}
