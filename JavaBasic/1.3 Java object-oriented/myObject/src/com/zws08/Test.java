package com.zws08;
/*
 * ����ͨ��Teacher�õ�Student����Ȼ�����Student��ķ���
 * ��������ķ���ֵ����������ʵ���ص��Ǹ���Ķ���
 */
public class Test {
	public static void main(String[] args) {
		//����һ��Teacher����
		Teacher ter = new Teacher();
		//ͨ������ter����Teacher�е�getStudent�����õ�Student����
		Student stu = ter.getStudent();
		stu.study();
	}
}
