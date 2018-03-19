package com.Brooke;
/*
 * 接口案例
 */
public class InterfaceDemo3 {
	public static void main(String[] args) {
		BasketballPlayer bbp = new BasketballPlayer();
		bbp.name = "科比";
		bbp.age = 40;
		bbp.show();
		bbp.speak();
		bbp.study();
		System.out.println("-------------");
		PingpongCoach ppc = new PingpongCoach();
		ppc.name = "刘国梁";
		ppc.age = 45;
		ppc.show();
		ppc.teach();
	}
}
//人
class Person {
	String name;
	int age;
	public void show() {
		System.out.println("人类");
	}
	
	
}
//运动员
abstract class Player extends Person {
	public abstract void study(); 
}
//教练
abstract class Coach extends Person {
	public abstract void teach();
}

//英语接口
interface English {
	public abstract void speak();
}

//篮球运动员
class BasketballPlayer extends Player implements English {

	@Override
	public void study() {
		System.out.println("篮球运动员学打篮球");
	}

	@Override
	public void speak() {
		System.out.println("篮球运动员讲英语");
		
	}
	
}
//乒乓球运动员
class PingpongPlayer extends Player implements English {

	@Override
	public void study() {
		System.out.println("乒乓球运动员学打乒乓球");
	}

	@Override
	public void speak() {
		System.out.println("乒乓球运动员讲英语");
		
	}
	
}
//篮球教练
class BasketballCoach extends Coach{

	@Override
	public void teach() {
		System.out.println("篮球教练教打篮球");
	}
	
}
//乒乓球教练
class PingpongCoach extends Coach {

	@Override
	public void teach() {
		System.out.println("乒乓球教练教打乒乓球");
	}
	
}