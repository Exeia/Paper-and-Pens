package com.example.paperandpens;
/*
 *Copyright (C)2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in https://github.com/Exeia/Paper-and-Pens/blob/master/License.txt
 *or in the source
 *distribution of this software for license terms.
*/
import java.util.ArrayList;
/* battle system ui*/

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;
public class Battle extends  Activity implements  View.OnClickListener  {
	ArrayList<Enemy> e;
	//this needs a thread...
	Button atk, skills, def, flee;
	String TAG = Battle.class.getSimpleName();
	TextView status, enemy_status;
	Thread running;
	Player person;
	Enemy data;
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
		//data = bd.getParcelableArrayList("en");
		//data = bd.getParcelable("en");
		//Log.d(TAG, data.get(0).getName());
		person = bd.getParcelable("PL");
        data = person.getEnemy();
		status = (TextView) findViewById(R.id.bStatus);
		atk = (Button) findViewById(R.id.atk);
		def = (Button) findViewById(R.id.def);
		skills = (Button) findViewById(R.id.skill);
		flee = (Button) findViewById(R.id.flee);
		
		//status.setText("You encounter, " + data.getEn().get(0).getName());
	
	
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
	
	public void useSkills(Skills s)
	{
		
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
		if(battle.isFlee()|| battle.isOver())
		{
			status.setText(battle.getStatus());
			battle.running(false);
		}
		
		else 
		{
			status.setText(battle.getStatus());
			enemy_status.setText(battle.getStatus());
		
		}
		}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "Resuming battle");
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "Pausing battle");
	}
	
	
}
