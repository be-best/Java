package com.Brooke01;

public class AbstractDemo1 {
	public static void main(String[] args) {
		Cat c = new Cat();
		c.show();
		Dog d = new Dog();
		d.show();
	}
}

abstract class Annimal {
	public abstract void show();
	public void run() {
		
	}
}

//�̳г�����һ��Ҫ��д�������еĳ��󷽷�
class Cat extends Annimal {
	public void show() {
		System.out.println("����è");
	}
}

//��������Ҳ�ǳ�������ô�̳г�����ʱ������д���󷽷�
abstract class Bird extends Annimal {
	
}

class Dog extends Annimal {
	public void show() {
		System.out.println("���ǹ�");
	}
	
}