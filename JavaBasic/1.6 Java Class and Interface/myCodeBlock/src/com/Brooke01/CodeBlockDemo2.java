package com.Brooke01;
/*
 * ��������
 */
public class CodeBlockDemo2 {
	public static void main(String[] args) {
		String name = "����ʦ";
		int age = 30;
		Teacher ter1 = new Teacher();
		Teacher ter2 = new Teacher(name,age);
	}
}

class Teacher {
	String name;
	int age;
	//��������,��ȡ���췽���еĹ��ԣ�ÿ�δ������󶼻�ִ�У������ڹ��췽��֮ǰִ��
	{
		//��ȡ���췽���еĹ��ԣ����"�Ұ�Java"
		System.out.println("�Ұ�Java��");
	}
	
	//�޲ι���
	public Teacher() {
		//System.out.println("�Ұ�Java��");
		System.out.println("�����޲ι���");
	}
	
	//�вι���
	public Teacher(String name,int age) {
		this.name = name;
		this.age = age;
		//System.out.println("�Ұ�Java��");
		System.out.println("�����вι���");
	}
}