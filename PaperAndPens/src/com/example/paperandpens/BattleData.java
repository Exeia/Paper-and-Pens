package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;
/*this will store data when the battle sequence initialize*/

public class BattleData implements Parcelable{
	
	
	public Player pl;
	public ArrayList <Enemy> en;
	String PLAYER = "PLAYER";
	public BattleData(Player pl, ArrayList<Enemy> en)
	{
		this.pl = pl;
		this.en = en;
		
	}
	public BattleData(Parcel in) {
		// TODO Auto-generated constructor stub
	}
	public Player getPlayer()
	{
		return pl;
	}
	public ArrayList<Enemy> getEn()
	{
		return en;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel writ, int flag) {
		// TODO Auto-generated method stub
		writ.writeParcelable(pl, flag);
		writ.writeTypedList(en);
		
	}
	public static final Parcelable.Creator<BattleData> CREATOR = 
			new Parcelable.Creator<BattleData>() {

				public BattleData createFromParcel(Parcel in) {
				    return new BattleData(in);
				}

				public BattleData[] newArray(int size) {
				    return new BattleData[size];
				}

				};
}
