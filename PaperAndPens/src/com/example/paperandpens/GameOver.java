package com.example.paperandpens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/*
 *Copyright (C)2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in https://github.com/Exeia/Paper-and-Pens/blob/master/License.txt
 *or in the source
 *distribution of this software for license terms.
*/
/*game over screen*/
public class GameOver extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.gameover);
		TextView over = (TextView) findViewById(R.id.over);
		over.setText("Game Over, you've either been stabbed, killed, or poisoned \n"+ "(╯°□°）╯︵ ┻━┻" );
		Button ok = (Button) findViewById(R.id.game_over_button);
		ok.setText("OK, leave");
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String tag = "Game over";
				Log.d(tag , "going main menu");
		//		Intent start = new Intent(GameOver.this, Welcome.class);
		//		startActivity(start);
				finish();
			}
		});
	}

}
