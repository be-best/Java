package com.Brooke02;
/*
 * �����ڲ���
 */
public class InnerDemo3 {
	public static void main(String[] args) {
		Outer out = new Outer();
		out.function();
	}
}

//�ӿ�
interface Inner {
	public void method();
}

//�ⲿ��
class Outer {
	public void function() {
		//�����ڲ��෽ʽ1
		new Inner() {

			@Override
			public void method() {
				System.out.println("�����ڲ��෽ʽ1");
				
			}
			
		}.method();;
	
		//�����ڲ��෽ʽ2
		Inner in = new Inner() {

			@Override
			public void method() {
				System.out.println("�����ڲ��෽ʽ2");
				
			}
			
		};
		in.method();
	}
}