package com.Brooke03;
/*
 * �����ڲ���Ӧ�ó���
 */
public class InnerDemo4 {
	public static void main(String[] args) {
		//methodEat(Animal a)
		methodEat(
				new Animal() {

					@Override
					public void eat() {
						System.out.println("è����");
						
					}
					
				}
				);
	}
	
	public static void methodEat(Animal a) {
		a.eat();
	}
}
