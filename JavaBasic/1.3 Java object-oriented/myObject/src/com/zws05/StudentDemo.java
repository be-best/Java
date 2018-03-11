package com.zws05;

public class StudentDemo {
	public static void main(String[] args) {
		//无参+setXxx
		Student stu = new Student();
		stu.setName("张大壮");
		stu.setAge(10);
		System.out.println(stu.getName()+","+stu.getAge());
		
		//带参构造
		Student stu1 = new Student("李大牛",11);
		System.out.println(stu1.getName()+","+stu1.getAge());
	}
}
