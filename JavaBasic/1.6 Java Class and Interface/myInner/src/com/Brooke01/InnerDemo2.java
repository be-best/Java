package com.Brooke01;
/*
 * �ֲ��ڲ��ࣺ
 * 		λ�ú;ֲ�����һ����λ�ڷ�����
 */
public class InnerDemo2 {
	public static void main(String[] args) {
		Outer1 out = new Outer1();
		out.method();
	}
}

//�ⲿ��
class Outer1 {
	int num;
	public void method() {
		//�ֲ��ڲ���
		class Inners {
			public void function() {
				System.out.println("Outer1-function");
			}
		}
		//����Inners����
		Inners in = new Inners();
		in.function();
	}
}