package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Jobs extends Activity implements View.OnClickListener{

	Intent player;
	Bundle pl_info;
	String name, job;
	String test = "rogue";
	int job_id;
	TextView jobName, jobInfo, charStat;
	Random stats = new Random();
	private int str =1, cons=1, mag, dex, hp, mp, range = 10;
	
	Player ch;
	Button confirm, reroll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jobinfo);
		Button next, reroll;
		next = (Button) findViewById(R.id.back);
		reroll = (Button) findViewById(R.id.reroll);
		player = getIntent();
		pl_info = player.getExtras();
		name = pl_info.getString("NAME");
		job_id = pl_info.getInt("JOB");
		jobName = (TextView) findViewById(R.id.title);
		jobInfo = (TextView) findViewById(R.id.info);
		charStat = (TextView) findViewById(R.id.status);
		next.setOnClickListener(this);
		reroll.setOnClickListener(this);
		jobInfo(job_id);
	}
	
	public void jobInfo(int id)
	{ 
		
		switch(id)
		{
		case R.string.rogue:
			jobName.setText("Rogue");
			jobInfo.setText("Sneaky Sneaky and Stabby Stabby \n" +
					"Skill set: \n"
					+ "Double stab: Attack opponents two times\n" +"Passive: 1% dexterity bonus \n");
			StatsGen(id);
			break;
		case R.string.Mage:
		
			jobName.setText("Mage");
			jobInfo.setText("You can shoot magic missile \n "+ "Skill set: \n"+
			"Limited Power: shot out one lighting bolt to enemy \n"+ "Passive: 2% mana increase" );
			StatsGen(id);
			break;
		case R.string.warrior:
			jobName.setText("Warrior");
			jobInfo.setText("A fierce fight who uses brute force to solve anything\n"+ 
			"Skill Set: \n"+
					"The Mighty Blow: 2x the base dmg\n" +
					"Passive: 1% strength increase\n");
			StatsGen(id);
			break;
			
		}
	}
	
	public void StatsGen(int id)
	{
		hp = 20;
		mp = 20;
	
		switch(id)
		{
		case R.string.warrior:
			str = stats.nextInt(range)+1;
			str = (int) (str + (str * 0.01)); //passive
			mag = stats.nextInt(range-1);
			cons = stats.nextInt(range)+1;
			dex = stats.nextInt(range)+1;
			charStat.setText("Character Stats: \n" 
					+ "Strength: " + str + "\n" 
					+ "Intelligence: "+ mag + "\n" 
					+ "Constitution: "+ cons + "\n" 
					+ "Dexterity: " + dex + "\n" 
					+ "HP: " + hp + "\n"
					+ "MP: " + mp + "\n");
			break;
		case R.string.rogue:
			str = stats.nextInt(range)+1;
			mag = stats.nextInt(range);
			cons = stats.nextInt(range)+1;
			dex = stats.nextInt(range)+2;
			dex = (int) (dex + (dex * 0.01)); //passive
			charStat.setText("Character Stats: \n" 
					+ "Strength: " + str + "\n" 
					+ "Intelligence: "+ mag + "\n" 
					+ "Constitution: "+ cons + "\n" 
					+ "Dexterity: " + dex + "\n" 
					+ "HP: " + hp + "\n"
					+ "MP: " + mp + "\n");
			break;
		case R.string.Mage:
			str = stats.nextInt(range)+1;
			mag = stats.nextInt(range)+2;
			cons = stats.nextInt(range)+1;
			dex = stats.nextInt(range)+1;
			mp = (int) (mp + (mp * 0.02)); //passive
			charStat.setText("Character Stats: \n" 
					+ "Strength: " + str + "\n" 
					+ "Intelligence: "+ mag + "\n" 
					+ "Constitution: "+ cons + "\n" 
					+ "Dexterity: " + dex + "\n" 
					+ "HP: " + hp + "\n"
					+ "MP: " + mp + "\n");
			break;
		}
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.back:
			ch = new Player(name,job, str, mag, dex, cons, hp, mp );
			
			break;
		case R.id.reroll:
			StatsGen(job_id);
			break;
		}
	}

}
