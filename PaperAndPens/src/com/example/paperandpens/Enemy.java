package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
import android.os.Parcel;

public class Enemy extends Player {

	public Enemy(String name, String job, int str, int mag, int dex, int cons,
			int hp, int mp) {
		super(name, job, str, mag, dex, cons, hp, mp);
		// TODO Auto-generated constructor stub
	}
	public Enemy(Parcel p)
	{
		super(p);
	}
}
