package com.example.paperandpens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Jobs extends Activity {

	Intent player;
	Bundle pl_info;
	String name;
	String test = "rogue";
	int job_id;
	TextView jobName, jobInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jobinfo);
		player = getIntent();
		pl_info = player.getExtras();
		name = pl_info.getString("NAME");
		job_id = pl_info.getInt("JOB");
		jobName = (TextView) findViewById(R.id.title);
		jobInfo = (TextView) findViewById(R.id.info);
		jobInfo(job_id);
	}
	
	public void jobInfo(int id)
	{ 
		
		switch(id)
		{
		case R.string.rogue:
			jobName.setText("Rogue");
			jobInfo.setText("Sneaky Sneaky and Stabby Stabby \n");
			break;
		case R.string.Mage:
		
			jobName.setText("Mage");
			jobInfo.setText("You can shoot magic missile \n lol");
			break;
		case R.string.warrior:
			jobName.setText("Warrior");
			jobInfo.setText("A fierce fight who uses brute force to solve anything\n");
			break;
			
		}
	}
	

}
