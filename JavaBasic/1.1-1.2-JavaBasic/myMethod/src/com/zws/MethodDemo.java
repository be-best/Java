package com.zws;

public class MethodDemo {
	public static void main(String[] args) {
		//��������,û������
		sum(10,20);
		//������ã������ã��п�����Ҫ�õ����
		System.out.println(sum(10,20));
		//��ֵ����
		int sums = sum(10,30);
		System.out.println(sums);
	}
	public static int sum(int a,int b){
		int c = a+b;
		return c;
	}
}
