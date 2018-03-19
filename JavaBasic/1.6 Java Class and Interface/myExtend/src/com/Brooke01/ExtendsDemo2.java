package com.Brooke01;
/*
 * 继承的特点：
 * 		Java支持单一继承，只能继承一个父类（一个儿子只能有一个亲爹）
 * 		Java支持多层继承（一个儿子可以有一个亲爹和一个亲爷爷）
 */
public class ExtendsDemo2 {
	public static void main(String[] args) {
		LOL l = new LOL();
		//单一继承：LOL extends PCGame
		l.show();
		
		//多层继承：LOL extends PCGame，PCGame extends Game
		l.start();
	}
}
class Game {
	public void start() {
		System.out.println("游戏启动了");
	}
}

class PCGame extends Game {
	public void show() {
		System.out.println("PC端游戏");
	}
}

class MobileGame {
	public void show() {
		System.out.println("Mobile端游戏");
	}
	
}

class LOL extends PCGame {
	
}