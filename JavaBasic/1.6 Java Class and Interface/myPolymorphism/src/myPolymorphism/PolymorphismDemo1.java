package myPolymorphism;
/*
 * ¶àÌ¬
 */
public class PolymorphismDemo1 {
	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Cat();
		a1.eat();
		a2.eat();
	}
}

class Animal { 
	public void eat () {
		System.out.println("³Ô¶«Î÷");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("Ã¨³ÔÓã");
	}
}