package com.Brooke;
/*
 * �ӿڰ���
 */
public class InterfaceDemo3 {
	public static void main(String[] args) {
		BasketballPlayer bbp = new BasketballPlayer();
		bbp.name = "�Ʊ�";
		bbp.age = 40;
		bbp.show();
		bbp.speak();
		bbp.study();
		System.out.println("-------------");
		PingpongCoach ppc = new PingpongCoach();
		ppc.name = "������";
		ppc.age = 45;
		ppc.show();
		ppc.teach();
	}
}
//��
class Person {
	String name;
	int age;
	public void show() {
		System.out.println("����");
	}
	
	
}
//�˶�Ա
abstract class Player extends Person {
	public abstract void study(); 
}
//����
abstract class Coach extends Person {
	public abstract void teach();
}

//Ӣ��ӿ�
interface English {
	public abstract void speak();
}

//�����˶�Ա
class BasketballPlayer extends Player implements English {

	@Override
	public void study() {
		System.out.println("�����˶�Աѧ������");
	}

	@Override
	public void speak() {
		System.out.println("�����˶�Ա��Ӣ��");
		
	}
	
}
//ƹ�����˶�Ա
class PingpongPlayer extends Player implements English {

	@Override
	public void study() {
		System.out.println("ƹ�����˶�Աѧ��ƹ����");
	}

	@Override
	public void speak() {
		System.out.println("ƹ�����˶�Ա��Ӣ��");
		
	}
	
}
//�������
class BasketballCoach extends Coach{

	@Override
	public void teach() {
		System.out.println("��������̴�����");
	}
	
}
//ƹ�������
class PingpongCoach extends Coach {

	@Override
	public void teach() {
		System.out.println("ƹ��������̴�ƹ����");
	}
	
}