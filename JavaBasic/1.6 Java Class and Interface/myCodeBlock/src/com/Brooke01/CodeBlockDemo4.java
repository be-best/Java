package com.Brooke01;

public class CodeBlockDemo4 {
	//CoderBlockDemo4�ľ�̬�����
	//ִ��һ�Σ�������ļ��ض�����
	static {
		System.out.println("CoderBlockDemo4�ľ�̬�����ִ��");
	}
	
	//CoderBlockDemo4�Ĺ�������
	//����ִ�У���Ϊֻ�д�������Ż�ִ�й������飬��Ȼ����û�д���CoderBlockDemo4�Ķ���
	{
		System.out.println("CoderBlockDemo4�ľ�̬�����ִ��");
	}
	public static void main(String[] args) {
		System.out.println("CodeBlockDemo4������ִ��");
		Coder c1 = new Coder();
		Coder c2 = new Coder();
	}
}

class Coder {
	//Coder�ľ�̬�����
	//ִ��һ�Σ�������ļ��ض�����
	static {
		System.out.println("Coder�ľ�̬�����ִ��");
	}
	
	//Coder�Ĺ�������
	//�޲ι���ǰִ��
	{
		System.out.println("Coder�Ĺ�������ִ��");
	}
	
	//Coder���޲ι���
	public Coder() {
		System.out.println("Coder���޲ι���ִ��");
	}
}