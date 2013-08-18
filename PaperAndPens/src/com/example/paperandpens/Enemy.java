package com.example.paperandpens;
/*
 *Copyright (C)2013 Peter Keomanvianh
 *[This program is licensed under the "GNU License"]
 *Please see the file LICENSE in https://github.com/Exeia/Paper-and-Pens/blob/master/License.txt
 *or in the source
 *distribution of this software for license terms.
*/
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Enemy implements Parcelable{

    private String name;
    String tag = Enemy.class.getSimpleName();
    private int hp,mp,atk,def,dex, exp;
    public Enemy(String name, int hp, int mp, int atk, int def, int dex, int exp)
    {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.dex = dex;
        this.hp = hp;
        this.mp = mp;
        this.exp = exp;
    }
     public Enemy(Parcel in)
     {
         name = in.readString();
         atk = in.readInt();
         def = in.readInt();
         dex = in.readInt();
         hp = in.readInt();
         mp = in.readInt();

     }
    public String getName()
    {
        return name;
    }

    public int getHp()
    {
        return hp;
    }

    public int getMp()
    {
        return mp;
    }

    public int getAtk()
    {
        return atk;
    }

    public int getDef()
    {
        return def;
    }
    public int getDex()
    {
        return dex;
    }

    public void setHp(int hp)
    {
        this.hp = this.hp - hp;
    }

    public int getExp()
    {
        return exp;
    }
    @Override
    public int describeContents() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void writeToParcel(Parcel out, int i) {

        out.writeString(getName());
        out.writeInt(getAtk());
        out.writeInt(getDef());
        out.writeInt(getDex());
        out.writeInt(getHp());
        out.writeInt(getMp());
    }
    public static final Parcelable.Creator<Enemy> CREATOR =
            new Parcelable.Creator<Enemy>() {

                public Enemy createFromParcel(Parcel in) {
                    return new Enemy(in);
                }

                public Enemy[] newArray(int size) {
                    return new Enemy[size];
                }

            };

}
