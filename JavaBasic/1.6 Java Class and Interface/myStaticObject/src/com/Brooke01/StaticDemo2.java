package com.Brooke01;
/*
 * ��̬��Ա����ֻ�ܵ��þ�̬(��Ա����/��Ա����)
 * �Ǿ�̬��Ա�������ܵ��þ�̬Ҳ�ܵ��÷Ǿ�̬(��Ա����/��Ա����)
 */
public class StaticDemo2 {
	public static void main(String[] args) {
		Student.graduateFrom = "��������"; 
		Student stu = new Student();
		stu.study();
	}
}

class Student {
	String name;
	int age;
	static String graduateFrom;
	
	//��̬��Ա����:study
	public static void study() {
		//��̬��Ա�������Ե��þ�̬��Ա����:����graduateFrom
		System.out.println(graduateFrom);
		//��̬��Ա�������Ե��þ�̬��Ա����������sleep
		sleep();
		
		//��̬��Ա�������ܵ��÷Ǿ�̬��Ա��������߲��ܵ���age
		//System.out.println(age);
		//��̬��Ա�������ܵ��÷Ǿ�̬��Ա��������߲��ܵ���eat����
		//eat();
	}
	
	//��̬��Ա������sleep
	public static void sleep() {
		System.out.println("˯����");
	}
	
	//�Ǿ�̬��Ա������eat
	public void eat() {
		System.out.println("��");
		//�Ǿ�̬��Ա�������Ե��þ�̬��Ա����:����graduateFrom
		System.out.println(graduateFrom);
		//�Ǿ�̬��Ա�������Ե��þ�̬��Ա����������sleep
		sleep();
		
		//���⣬�Ǿ�̬��Ա�������Ե��÷Ǿ�̬��Ա�����ͱ���
		
	}
}