package com.Brooke01;
/*
 * ��̬�����
 */
public class CodeBlockDemo3 {
	public static void main(String[] args) {
		String name = "����ʦ";
		int age = 30;
		Teacher1 ter1 = new Teacher1();
		Teacher1 ter2 = new Teacher1(name,age);
	}
}

class Teacher1 {
	String name;
	int age;
	
	//��̬�����:������ļ��ض����أ�ֻ����һ�Σ�������ʱ��Ҫ����һЩ��ʼ���������������
	static{
		//��ȡ���췽���еĹ��ԣ����"�Ұ�Java"
		System.out.println("�Ұ�Java��");
	}
	
	//�޲ι���
	public Teacher1() {
		//System.out.println("�Ұ�Java��");
		System.out.println("�����޲ι���");
	}
	
	//�вι���
	public Teacher1(String name,int age) {
		this.name = name;
		this.age = age;
		//System.out.println("�Ұ�Java��");
		System.out.println("�����вι���");
	}
}