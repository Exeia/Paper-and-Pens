package com.example.paperandpens;

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
