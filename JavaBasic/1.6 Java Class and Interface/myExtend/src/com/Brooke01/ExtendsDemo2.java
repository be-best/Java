package com.Brooke01;
/*
 * �̳е��ص㣺
 * 		Java֧�ֵ�һ�̳У�ֻ�ܼ̳�һ�����ࣨһ������ֻ����һ���׵���
 * 		Java֧�ֶ��̳У�һ�����ӿ�����һ���׵���һ����үү��
 */
public class ExtendsDemo2 {
	public static void main(String[] args) {
		LOL l = new LOL();
		//��һ�̳У�LOL extends PCGame
		l.show();
		
		//���̳У�LOL extends PCGame��PCGame extends Game
		l.start();
	}
}
class Game {
	public void start() {
		System.out.println("��Ϸ������");
	}
}

class PCGame extends Game {
	public void show() {
		System.out.println("PC����Ϸ");
	}
}

class MobileGame {
	public void show() {
		System.out.println("Mobile����Ϸ");
	}
	
}

class LOL extends PCGame {
	
}