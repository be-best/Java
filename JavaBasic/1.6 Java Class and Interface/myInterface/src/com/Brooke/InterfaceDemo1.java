package com.Brooke;
/*
 * �ӿ�
 */
public class InterfaceDemo1 {
	public static void main(String[] args) {
		Cat c = new Cat();
		c.eat();
		c.sleep();
		//�ӿڿ���ֱ�ӵ���num,˵��numǰĬ����static����
		System.out.println(Annimal.num);
	}
}

//����һ���ӿ�
interface Annimal {
	//Ĭ����public static final���γ���
	public static final int num = 10;
	//Ĭ����public abstract���η���
	public abstract void eat();
	public abstract void sleep();	
	}

//����ӿ���ʵ��(implements)��ϵ,Ҫʵ�ֽӿڵ����з���
class Cat implements Annimal{

	@Override
	public void eat() {
		System.out.println("�Զ���");
		
	}

	@Override
	public void sleep() {
		System.out.println("˯��");
		
	}
	
}
