package com.Brooke;
/*
 * 接口
 */
public class InterfaceDemo1 {
	public static void main(String[] args) {
		Cat c = new Cat();
		c.eat();
		c.sleep();
		//接口可以直接调用num,说明num前默认有static修饰
		System.out.println(Annimal.num);
	}
}

//定义一个接口
interface Annimal {
	//默认用public static final修饰常量
	public static final int num = 10;
	//默认用public abstract修饰方法
	public abstract void eat();
	public abstract void sleep();	
	}

//类与接口是实现(implements)关系,要实现接口的所有方法
class Cat implements Annimal{

	@Override
	public void eat() {
		System.out.println("吃东西");
		
	}

	@Override
	public void sleep() {
		System.out.println("睡觉");
		
	}
	
}
