package com.Brooke01;
/*
 * 抽象类案例1
 */
public class AbstractDemo3 {
	public static void main(String[] args) {
		BasicTeacher bt = new BasicTeacher();
		bt.name = "苍老师";
		bt.teach();
		
		WorkTeacher wt = new WorkTeacher();
		wt.name = "波多老师";
		wt.teach();
	}
}

abstract class Teacher {
	String name;
	int age;
	public abstract void teach();
}

class BasicTeacher extends Teacher{

	@Override
	public void teach() {
		System.out.println(name+"讲解基础班课程");
		
	}
	
}

class WorkTeacher extends Teacher{

	@Override
	public void teach() {
		System.out.println(name+"讲解进阶班课程");
		
	}
	
}