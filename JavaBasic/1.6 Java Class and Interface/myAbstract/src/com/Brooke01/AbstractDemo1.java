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

//继承抽象类一定要重写抽象类中的抽象方法
class Cat extends Annimal {
	public void show() {
		System.out.println("这是猫");
	}
}

//如果这个类也是抽象类那么继承抽象类时不用重写抽象方法
abstract class Bird extends Annimal {
	
}

class Dog extends Annimal {
	public void show() {
		System.out.println("这是狗");
	}
	
}