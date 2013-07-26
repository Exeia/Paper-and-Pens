package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

import android.app.Activity;
import android.os.Bundle;
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
	RadioButton b1,b2,b3, b4;

	Player pl;
	Random rd = new Random();
	boolean c1 = false,c2 = false,c3= false, c4 = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.start);
		/*b1 = (Button) findViewById(R.id.choice1);
		b2 = (Button) findViewById(R.id.choice2);
		b3 = (Button) findViewById(R.id.choice3);
		b4 = (Button) findViewById(R.id.choice4);*/
		b1 = (RadioButton) findViewById(R.id.choice1);
		b2 = (RadioButton) findViewById(R.id.choice2);
		b3 = (RadioButton) findViewById(R.id.choice3);
		b4 = (RadioButton) findViewById(R.id.choice4);
		
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
		String input = null;
		
			status.setText("You are in the forest, there is a village a few miles away from where you are. There are two path ways, " +
					"one going left and one going straight");
			b1.setText("Search around your surrounding.\n");
			b2.setText("Sleep in a creepy yet serene forest. \n");
			b3.setText("Proceed straight.\n");
			b4.setText("Take the left turn. \n");
			input=checkedInput();
			if(input.equals("c1"))
			{
				checked1();
			}
			else if(input.equals("c2"))
			{
				
			}
			else if (input.equals("c3"))
			{
				
			}
			else 
			{
				
			}
	//	}
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
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		 
		}
	}
	
public void newChoice()
{
	c1 =false;
	c2 =false;
	c3 =false; 
	c4 =false;
}
public void checked1()
{
	status.setText("You look around your surroundings and... suddenly "); 
}

}
