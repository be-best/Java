package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 泛型：
 * 	API中有<E>时可使用，<String>、<Student>...
 */
public class Generics {
	public static void main(String[] args) {
		//创建集合对象	
		Collection<Student> c = new ArrayList<Student>();
		Student stu1 = new Student("张三",10);
		Student stu2 = new Student("李四",11);
		c.add(stu1);
		c.add(stu2);
		//采用迭代器方法打印name
		Iterator<Student> it = c.iterator();
		while(it.hasNext()) {
			Student stu = it.next();
			System.out.println(stu.name);
		}
	}
}

class Student {
	String name;
	int age;
	
	public Student() {
		
	}
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
}