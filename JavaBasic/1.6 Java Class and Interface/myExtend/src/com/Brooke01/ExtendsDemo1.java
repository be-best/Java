package com.Brooke01;
/*
 * �̳�
 */
public class ExtendsDemo1 {
	public static void main(String[] args) {
		BasketballTeam bask = new BasketballTeam();
		bask.teamName = "����";
		bask.playerNum = 12;
		bask.country = "����";
		System.out.println(bask.teamName+"---"+bask.playerNum+"---"+bask.country);
		bask.champion();
		FootballTeam foot = new FootballTeam();
		bask.teamName = "��������";
		bask.playerNum = 25;
		bask.country = "������";
		System.out.println(foot.teamName+"---"+foot.playerNum+"---"+foot.country);
		foot.champion();
	}
}

class Team {
	String teamName;
	String country;
	int playerNum;
	
	public void champion() {
		System.out.println("�����ǹھ���");
	}
	
}
class BasketballTeam extends Team{
	
}

class FootballTeam extends Team{
	
}
