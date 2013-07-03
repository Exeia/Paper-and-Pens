/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
package com.example.paperandpens;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class Welcome extends Activity {

	Button newGame,loadGame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		newGame = (Button)findViewById(R.id.newGame);
		loadGame = (Button)findViewById(R.id.loadGame);
		newGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
				Class ng = Class.forName("com.example.paperandpens.NewGame");
				Intent ngIntent = new Intent(Welcome.this, ng);
				startActivity(ngIntent);
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				
			}
		});
		loadGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					Class ld = Class.forName("com.example.paperandpens.NewGame");
					Intent ldIntent = new Intent(Welcome.this, ld);
					startActivity(ldIntent);
					}
					catch(ClassNotFoundException e)
					{
						e.printStackTrace();
					}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
