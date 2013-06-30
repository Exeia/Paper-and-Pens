package com.example.text_base_rpg;

//Character class
public class Character {
	
		private static String name, job_class;
	
		private static int str,intel, dex, hp,mp;
		public Character(String name,String job_class ,int str, int dex, int intel, int hp, int mp )
		{
			Character.name = name;
			Character.str = str;
			Character.dex = dex;
			Character.intel = intel;
			Character.hp = hp;
			Character.mp = mp;
			Character.job_class = job_class;
			
		}
		public String getName()
		{
			return name;
		}
		public String getJobClass()
		{
			return job_class;
		}
		public int getStr()
		{
			return str;
		}
		public int getDex()
		{
			return dex;
		}
		public int getIntel()
		{
			return intel;
		}
		public int getHP()
		{
			return hp;
		}
		public int getMP()
		{
			return mp;
		}
		public static void Level_up(int addStr, int addDex, int addIntel,int addhp, int addmp)
		{
			str += addStr;
			dex += addDex;
			intel += addIntel;
			hp += addhp;
			mp += addmp;
			
			
		}
}
