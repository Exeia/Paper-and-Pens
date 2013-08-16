package com.example.paperandpens;
/*
 *Copyright (C)2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in https://github.com/Exeia/Paper-and-Pens/blob/master/License.txt
 *or in the source
 *distribution of this software for license terms.
*/
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class JobSelection extends Activity implements View.OnClickListener {

	String player ="";
	TextView txt;
	Button wa,ma,ti;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jobclass);
		txt = (TextView) findViewById(R.id.jb);
		Intent na = getIntent();
		Bundle ext = na.getExtras();
		player = ext.getString("NAME");
		classSelection();
		txt.setText(player + ", Select a class.");
		
	}
	private void classSelection()
	{
		wa = (Button) findViewById(R.id.warrior);
		ma = (Button) findViewById(R.id.mage);
		ti = (Button) findViewById(R.id.rogue);
		wa.setOnClickListener(this);
		ma.setOnClickListener(this);
		ti.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		String job= null;
		Intent jb;
		Bundle b;
		switch(v.getId())
		{
		case R.id.warrior:
			job = "warrior";
			jb = new Intent(JobSelection.this,Jobs.class);
			b = new Bundle();
			b.putString("NAME", player);
			b.putInt("JOB", R.string.warrior);
			jb.putExtras(b);
			startActivity(jb);
			finish();
			break;
		case R.id.mage:
			job = "mage";
			jb = new Intent(JobSelection.this,Jobs.class);
			b = new Bundle();
			b.putString("NAME", player);
			b.putInt("JOB",R.string.Mage);
			jb.putExtras(b);
			startActivity(jb);
			finish();
			break;
		case R.id.rogue:
			job = "rogue";
			jb = new Intent(JobSelection.this,Jobs.class);
			b = new Bundle();
			b.putString("NAME", player);
			b.putInt("JOB",R.string.rogue);
			jb.putExtras(b);
			startActivity(jb);
			finish();
			break;
			
		}
		
	}
	
	
	
}
