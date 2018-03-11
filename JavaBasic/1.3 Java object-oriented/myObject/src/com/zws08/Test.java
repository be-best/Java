package com.zws08;
/*
 * 需求：通过Teacher得到Student对象，然后调用Student类的方法
 * 如果方法的返回值是类名，其实返回的是该类的对象
 */
public class Test {
	public static void main(String[] args) {
		//创建一个Teacher对象
		Teacher ter = new Teacher();
		//通过对象ter调用Teacher中的getStudent方法得到Student对象
		Student stu = ter.getStudent();
		stu.study();
	}
}
