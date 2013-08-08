package com.example.paperandpens;
/*
 *Copyright (C) 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import java.util.*;
public class StartGame extends Activity implements  View.OnClickListener{
	int OPTION = 4, ONE = 1, TWO =2, THREE = 3, FOUR =4;
	Thread t;
	EditText cmd;
	TextView status, response;
	Button b1,b2,b3, b4;
	String TAG = StartGame.class.getSimpleName();
	String ch [] = new String[OPTION];
	int state = 0;
	Player pl;
	BattleData data; 
	Random rd = new Random();
	String PLAYER = "PLAYER", ENEMY ="ENEMY";
	
	GameScript gm;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.start);
		b1 = (Button) findViewById(R.id.choice1);
		b2 = (Button) findViewById(R.id.choice2);
		b3 = (Button) findViewById(R.id.choice3);
		b4 = (Button) findViewById(R.id.choice4);
		Intent na = getIntent();
		Bundle ext = na.getExtras();
		pl = ext.getParcelable("character");
	
		response = (TextView) findViewById(R.id.response);
		status = (TextView) findViewById(R.id.start);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		if(isLoaded() == false)
		{
			script();
		}
		
		
	}
	public void script()
	{
			gm = new GameScript(pl);
			
			status.setText(gm.getScene());
			response.setText(gm.getPl_res());
			ch = gm.getChoices();
			
			b1.setText(ch[0]);
			b2.setText(ch[1]);
			b3.setText(ch[2]);
			b4.setText(ch[3]);
			gm.setRunning(true);
			gm.start();
		
	}
	
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "Pausing...");
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "Resuming...");
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String choice = null;
		switch(v.getId())
		{
		case R.id.choice1:
			choice = (String) b1.getText();
			gm.chose(ONE);
			try {
				Thread.sleep(1000);
				update();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			Log.d(TAG, choice);
			
			break;
		case R.id.choice2:
			choice = (String) b2.getText();
			gm.chose(TWO);
			try {
				Thread.sleep(1000);
				update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Log.d(TAG, choice);
			break;
		case R.id.choice3:
			choice = (String) b3.getText();
			gm.chose(THREE);
			try {
				Thread.sleep(1000);
				update();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.d(TAG, choice);
			break;
		case R.id.choice4:
			choice = (String) b4.getText();
			gm.chose(FOUR);
			try {
				Thread.sleep(1000);
				update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Log.d(TAG, choice);
			break;
		case R.id.Items:
			Intent it = new Intent(StartGame.this, ItemList.class);
			
			break;
		}
		
	}

@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	Log.d(TAG,"Destroying..");
	gm.setRunning(false);
}
public void update()
{
	String scene = gm.getScene();
	status.setText(scene);
	response.setText(gm.getPl_res());
	ch = gm.getChoices();
	if(gm.getBattle())
	{
		Intent battle = new Intent (StartGame.this, Battle.class);
		data = gm.getData();
		battle.putExtra("BD", data);
		
		
	}
	else if(gm.isOver())
	{
		Log.d(TAG, "Game over");
		Intent over = new Intent (StartGame.this, GameOver.class);
		startActivity(over);
		this.finish();
	}
	else
	{
		b1.setText(ch[0]);
		b2.setText(ch[1]);
		b3.setText(ch[2]);
		b4.setText(ch[3]);
			
	}
	
}


public boolean isLoaded()
{
	return false;
}
}
