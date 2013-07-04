/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
package com.example.paperandpens;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.*;
public class NewGame extends Activity {

	Button enter;
	TextView txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);
		enter = (Button)findViewById(R.id.enter);
		txt = (TextView)findViewById(R.id.textView1);
		
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText input = (EditText) findViewById(R.id.editText);
				String name = input.getText().toString();
				txt.setText("Welcome "+ name);
			}
		});
		
		
	}
	
	

	
}
