package com.zws08;

public class Teacher {
	// 如果方法的返回值是类名，其实返回的是该类的对象,如下：
	public Student getStudent() {
		Student s = new Student();
		return s;
	}
}
