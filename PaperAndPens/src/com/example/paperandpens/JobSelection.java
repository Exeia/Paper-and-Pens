package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class JobSelection extends Activity implements View.OnClickListener {

	//String jobselection[] = {"Warrior","Rogue","Magi"};
	String player ="";
	TextView txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jobclass);
		txt = (TextView) findViewById(R.id.jb);
		Intent na = getIntent();
		Bundle ext = na.getExtras();
		player = ext.getString("NAME");
		txt.setText(player + ", Select a class.");
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.warrior:
			
			break;
		case R.id.mage:
			break;
		case R.id.rogue:
			break;
			
		}
		
	}
	
	
	
}
