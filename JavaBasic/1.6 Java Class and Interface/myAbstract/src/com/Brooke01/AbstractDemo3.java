package com.Brooke01;
/*
 * �����స��1
 */
public class AbstractDemo3 {
	public static void main(String[] args) {
		BasicTeacher bt = new BasicTeacher();
		bt.name = "����ʦ";
		bt.teach();
		
		WorkTeacher wt = new WorkTeacher();
		wt.name = "������ʦ";
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
		System.out.println(name+"���������γ�");
		
	}
	
}

class WorkTeacher extends Teacher{

	@Override
	public void teach() {
		System.out.println(name+"������װ�γ�");
		
	}
	
}