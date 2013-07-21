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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartGame extends Activity implements  View.OnClickListener{

	Thread t;
	EditText cmd;
	TextView status;
	Button b1,b2,b3, b4;
	boolean c1 = false,c2 = false,c3= false, c4 = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		b1 = (Button) findViewById(R.id.choice1);
		b2 = (Button) findViewById(R.id.choice2);
		b3 = (Button) findViewById(R.id.choice3);
		b4 = (Button) findViewById(R.id.choice4);
		status = (TextView) findViewById(R.id.start);
		
		
	}
	public void start()
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
			
	//	}
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	


}
