package com.example.paperandpens;

import java.util.ArrayList;

public class BattleSeq extends Thread {

	BattleData data;
	public BattleSeq(BattleData data)
	{
		this.data = data;
		init();
	}
	public void init()
	{
		run();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		Player pl = data.getPlayer();
		ArrayList<Enemy> en = data.getEn();
		
	}
	
}
