package com.zws05;

public class StudentDemo {
	public static void main(String[] args) {
		//�޲�+setXxx
		Student stu = new Student();
		stu.setName("�Ŵ�׳");
		stu.setAge(10);
		System.out.println(stu.getName()+","+stu.getAge());
		
		//���ι���
		Student stu1 = new Student("���ţ",11);
		System.out.println(stu1.getName()+","+stu1.getAge());
	}
}
