package com.Brooke01;
/*
 * 继承
 */
public class ExtendsDemo1 {
	public static void main(String[] args) {
		BasketballTeam bask = new BasketballTeam();
		bask.teamName = "湖人";
		bask.playerNum = 12;
		bask.country = "美国";
		System.out.println(bask.teamName+"---"+bask.playerNum+"---"+bask.country);
		bask.champion();
		FootballTeam foot = new FootballTeam();
		bask.teamName = "巴塞罗那";
		bask.playerNum = 25;
		bask.country = "西班牙";
		System.out.println(foot.teamName+"---"+foot.playerNum+"---"+foot.country);
		foot.champion();
	}
}

class Team {
	String teamName;
	String country;
	int playerNum;
	
	public void champion() {
		System.out.println("我们是冠军！");
	}
	
}
class BasketballTeam extends Team{
	
}

class FootballTeam extends Team{
	
}
