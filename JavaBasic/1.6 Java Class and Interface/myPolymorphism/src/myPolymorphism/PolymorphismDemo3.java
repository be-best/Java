package myPolymorphism;
/*
 * ��̬�����Ϻ�����ת��
 */
public class PolymorphismDemo3 {
	public static void main(String[] args) {
		//����ת��
		Animals a = new Dog();
		a.eat();
		
		//����ת��,swim()�Ǹ���û�ж�����Dog�еĳ�Ա����
		Dog d = (Dog)a;
		d.swim();
	}
}

class Animals {
	public void eat() {
		System.out.println("�Զ���");
	}
}

class Dog extends Animals {
	public void eat() {
		System.out.println("�й�ͷ");
	}
	
	public void swim() {
		System.out.println("����");
	}
}