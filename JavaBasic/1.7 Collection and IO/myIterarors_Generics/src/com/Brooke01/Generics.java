package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * ���ͣ�
 * 	API����<E>ʱ��ʹ�ã�<String>��<Student>...
 */
public class Generics {
	public static void main(String[] args) {
		//�������϶���	
		Collection<Student> c = new ArrayList<Student>();
		Student stu1 = new Student("����",10);
		Student stu2 = new Student("����",11);
		c.add(stu1);
		c.add(stu2);
		//���õ�����������ӡname
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