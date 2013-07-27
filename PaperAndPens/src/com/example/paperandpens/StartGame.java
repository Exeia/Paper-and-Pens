package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.*;
public class StartGame extends Activity implements  View.OnClickListener{

	Thread t;
	EditText cmd;
	TextView status;
	Button b1,b2,b3, b4;
	String TAG = StartGame.class.getSimpleName();

	Player pl;
	Random rd = new Random();
	boolean c1 = false,c2 = false,c3= false, c4 = false;
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
		/*b1 = (RadioButton) findViewById(R.id.choice1);
		b2 = (RadioButton) findViewById(R.id.choice2);
		b3 = (RadioButton) findViewById(R.id.choice3);
		b4 = (RadioButton) findViewById(R.id.choice4);*/
		
		status = (TextView) findViewById(R.id.start);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		script();
		
	}
	public void script()
	{
	//	boolean running = true;
	//	while (running)
	//	{
	
			status.setText("You are in the forest, there is a village a few miles away from where you are. There are two path ways, " +
					"one going left and one going straight");
			b1.setText("Search around your surrounding.\n");
			b2.setText("Sleep in a creepy yet serene forest. \n");
			b3.setText("Proceed straight.\n");
			b4.setText("Take the left turn. \n");
			
		
	}
	
	
	public String checkedInput()
	{
		String choice = null;
		if (c1)
		{
			choice = "c1";
		}
		else if(c2)
		{
			choice = "c2";
			}
		else if (c3)
		{
			choice = "c3";
		}
		else 
		{
			choice = "c4";
		}
		
		return choice;
	}
	public void selection()
	{
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);

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
			
			Log.d(TAG, choice);
			break;
		case R.id.choice2:
			choice = (String) b2.getText();
			Log.d(TAG, choice);
			break;
		case R.id.choice3:
			choice = (String) b3.getText();
			Log.d(TAG, choice);
			break;
		case R.id.choice4:
			choice = (String) b3.getText();
			Log.d(TAG, choice);
			break;
			
		}
	}
	
public void newChoice()
{
	c1 =false;
	c2 =false;
	c3 =false; 
	c4 =false;
}

@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	Log.d(TAG,"Destroying..");
}

public void checked1()
{
	status.setText("You look around your surroundings and... suddenly "); 
}

}
