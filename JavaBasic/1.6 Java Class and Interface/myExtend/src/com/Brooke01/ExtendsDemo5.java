package com.Brooke01;
/*
 * �����ִ��˳��
 */
public class ExtendsDemo5 {
	public static void main(String[] args) {
		Son1 s = new Son1();
	} 
}

class Dad1 {
	public Dad1() {
		System.out.println("���Ǹ����޲ι���");
	}
	
	public Dad1(int num) {
		System.out.println("���Ǹ����вι���");
	}
}

class Son1 extends Dad1{
	public Son1() {
		this(1);//����������вι��죬��ô������޲ι��첻������ã�������������вι����е��á�
		System.out.println("���������޲ι���");
	}
	public Son1(int num) {
		System.out.println("���������вι���");
	}
	
}