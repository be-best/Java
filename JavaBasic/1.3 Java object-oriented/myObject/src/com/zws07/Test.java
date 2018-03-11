package com.zws07;

/*
 * 调用teacher的test方法
 * 类名作为形式参数，需要的其实是该类的对象
 */
public class Test {
	public static void main(String[] args) {
		//调用teacher类的方法，先创建一个teacher对象
		Teacher t = new Teacher();
		//teacher类中形式参数是Student s,所以创建一个Student对象
		Student s = new Student();
		t.test(s);
	}
	
}
