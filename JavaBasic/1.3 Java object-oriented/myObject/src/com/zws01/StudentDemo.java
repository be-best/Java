package com.zws01;

public class StudentDemo {
	public static void main(String[] args) {
		Student stu = new Student();
		
		//���ó�Ա����
		stu.study();
		stu.eat();
		System.out.println("-----------");
		//����Ա������ֵ
		stu.age=18;
		stu.name="����";
		//�����Ա����
		System.out.println("�����ǣ�"+stu.name);
		System.out.println("�����ǣ�"+stu.age);
	}
}
