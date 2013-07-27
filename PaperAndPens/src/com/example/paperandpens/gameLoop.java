package com.example.paperandpens;

public class gameLoop extends Thread {

	
	private boolean running;
	GameScript game;
	public void setRunning(boolean running)
	{
		this.running = running;
	}
	public gameLoop(GameScript game)
	{
		super();
		this.game = game;
	}
	
	public void run()
	{
		while(running)
		{
			
		}
	}
}
