package com.Brooke01;
/*
 * �̳��г�Ա�������ص�
 */
public class ExtendsDemo3 {
	public static void main(String[] args) {
		Son s =new Son();
		s.show();
	}
}

class Dad {
	String name = "��һ";
}

class Son extends Dad{
	String name = "�Ŷ�";
	public void show() {
		String name = "����";
		
		//�����Ա����
		System.out.println(super.name);
		//����ĳ�Ա����
		System.out.println(this.name);
		//�˷����еľֲ�����
		System.out.println(name);
	}
}