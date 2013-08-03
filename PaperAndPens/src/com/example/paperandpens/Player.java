package com.example.paperandpens;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/
import java.util.ArrayList;
/*
 *Copyright 2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in the source
 *distribution of this software for license terms.
*/

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;


@SuppressLint("ParcelCreator")
public class Player implements Parcelable {
	private String na, jo;
	//stats
	private int str,mag,dex,con,hp,mp, basedmg, exp;
	//skill list
	private ArrayList <Skills> ch_skill = new ArrayList<Skills>();
	//item inventory
	private ArrayList <Item> inventory = new ArrayList<Item>();
	public Player(String name, String job, int str, int mag, int dex, int cons, int hp,int mp)
	{
		na = name;
		jo = job;
		this.str = str;
		this.dex = dex;
		this.con= cons;
		this.hp = hp;
		this.mp = mp;
		basedmg =  (str + dex)/2;
		exp = 0;
	}
	public Player(Parcel input)
	{
		readFromParcel(input); 
	}
	public int getBased()
	{
		return basedmg;
	}
	private void readFromParcel(Parcel input) {
		// TODO Auto-generated method stub
		na = input.readString();
		jo = input.readString();
		str = input.readInt();
		mag = input.readInt();
		dex = input.readInt();
		con = input.readInt();
		hp = input.readInt();
		
	}
	public boolean isLevelup()
	{
		if(exp >= 100 )
		{
			exp = exp -100;
			return true;
		}
		else 
		{
			return false;
		}
	}
	public String getJob()
	{
		return jo;
		
	}
	public String getName()
	{
		return na;
	
	}
	
	public void equipWeapon(Weapon w)
	{
		basedmg = basedmg + w.getDmgInput();
	}
	public void unequipWeapon(Weapon w)
	{
		basedmg = basedmg - w.getDmgInput();
	}
	public void equipArmor(Armor arm)
	{
		con = con + arm.getArmDef() ;
	}
	public void unequipArmor(Armor arm)
	{
		con = con - arm.getArmDef() ;
	}
	
	public int getStr()
	{
		return str;
	}
	public int getMag()
	{
		return mag;
	}
	public int getDex()
	{
		return dex;
	}
	public int getCon()
	{
		return con;
	}
	public int getHp()
	{
		return hp;
	}
	public int getMp()
	{
		return mp;
		
	}
	public void Damaged(int d)
	{
		hp = hp - d;
	}
	
	public void useMp (int m)
	{
		mp = mp -m;
		
	}
	public void addSkills(Skills sk)
	{
		ch_skill.add(sk);
	}
	public Skills getSkill(String s)
	{
		Skills found = null;
		for(int i = 0; i < ch_skill.size(); i++)
		{
			if(s.equals(ch_skill.get(i).getName()))
			{
				found = ch_skill.get(i);
			}
		}
		return found;
	}
	public void levelUp(int strength, int intell, int dexterity, int cons, int hitpt, int magpt)
	{
		str = str + strength;
		mag = mag + intell;
		dex = dex + dexterity;
		con = con + cons;
		hp = hp + hitpt;
		mp = mp + magpt;
		basedmg = basedmg + (int)((str+dex)/2); 
		
	}
	public void addSkill(Skills s)
	{
		ch_skill.add(s);
	}
	public Skills getSkills(String s)
	{
		Skills skill = null, temp;
		for(int i = 0; i < ch_skill.size(); i++)
		{
			temp = ch_skill.get(i);
			if(temp.getName().equals(s) )
			{
				skill = temp;
			}
		}
		return skill;
	}
	public Item getItem(String s)
	{

		Item found = null;
		for(int i = 0; i < ch_skill.size(); i++)
		{
			
			if(inventory.get(i).getName().equals(s))
			{
				found = inventory.get(i);
			}
		}
		return found;
	}
	public void addtoInventory(Item i)
	{
		inventory.add(i);
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel out, int flag) {
		String tag = null;
		// TODO Auto-generated method stub
		Log.v(tag, "writing parcel.."+ flag);
		out.writeString(getName());
		out.writeString(getJob());
		out.writeInt(getStr());
		out.writeInt(getMag());
		out.writeInt(getDex());
		out.writeInt(getCon());
		out.writeInt(getHp());
		out.writeInt(getMp());
	}	
public static final Parcelable.Creator<Player> CREATOR = 
new Parcelable.Creator<Player>() {

	public Player createFromParcel(Parcel in) {
	    return new Player(in);
	}

	public Player[] newArray(int size) {
	    return new Player[size];
	}

	};
	

}
