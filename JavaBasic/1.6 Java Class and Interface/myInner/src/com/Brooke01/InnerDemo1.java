package com.Brooke01;
/*
 * ��Ա�ڲ��ࣺ
 * 		λ�úͳ�Ա��������Ա�������ڵ�λ��һ����λ�����з�����
 * 		�ڲ������ֱ�ӷ����ⲿ���Ա������˽�г�Ա
 */
public class InnerDemo1 {
	public static void main(String[] args) {
		//����Outer����
		Outer out = new Outer();
		out.method();
		//����Inner����
		Outer.Inner in = new Outer().new Inner();
		in.fuction();
		//����static���ε�Inner1����,ֱ��new�ڲ���Ķ���,���ô����ⲿ�����
		Outer.Inner1 in1 = new Outer.Inner1();
		in1.fuction();
		//ֱ�����ڲ����������÷�������ʱ�ڲ���ͷ�����Ҫ��static����
		Outer.Inner2.fuction();
	}
}

//�ⲿ��
class Outer {
	private int num;
	public void method() {
		Inner i = new Inner();
		i.fuction();
	}
	
	//��Ա�ڲ���
	class Inner {
		public void fuction() {
			System.out.println("Inner�ڲ���");
		}
	}
	
	static class Inner1 {
		public void fuction() {
			System.out.println("Inner1�ڲ���");
		}
		
	}
	
	static class Inner2 {
		public static void fuction() {
			System.out.println("Inner2�ڲ���");
		}
		
	}
}
