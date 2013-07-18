package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartGame extends Activity{

	Thread t;
	EditText cmd;
	TextView status;
	Button b1,b2,b3;
	boolean c1 = false,c2 = false,c3= false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		b1 = (Button) findViewById(R.id.choice1);
		b2 = (Button) findViewById(R.id.choice2);
		b3 = (Button) findViewById(R.id.choice3);
		status = (TextView) findViewById(R.id.start);
		
	}
	public void start()
	{
		boolean running = true;
		while (running)
		{
			
		}
	}
	


}
