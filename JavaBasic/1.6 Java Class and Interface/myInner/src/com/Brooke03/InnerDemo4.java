package com.Brooke03;
/*
 * 匿名内部类应用场景
 */
public class InnerDemo4 {
	public static void main(String[] args) {
		//methodEat(Animal a)
		methodEat(
				new Animal() {

					@Override
					public void eat() {
						System.out.println("猫吃鱼");
						
					}
					
				}
				);
	}
	
	public static void methodEat(Animal a) {
		a.eat();
	}
}
