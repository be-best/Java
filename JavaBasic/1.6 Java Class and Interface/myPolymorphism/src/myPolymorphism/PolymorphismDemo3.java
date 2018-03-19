package myPolymorphism;
/*
 * 多态的向上和向下转型
 */
public class PolymorphismDemo3 {
	public static void main(String[] args) {
		//向上转型
		Animals a = new Dog();
		a.eat();
		
		//向下转型,swim()是父类没有而子类Dog有的成员方法
		Dog d = (Dog)a;
		d.swim();
	}
}

class Animals {
	public void eat() {
		System.out.println("吃东西");
	}
}

class Dog extends Animals {
	public void eat() {
		System.out.println("啃骨头");
	}
	
	public void swim() {
		System.out.println("狗刨");
	}
}