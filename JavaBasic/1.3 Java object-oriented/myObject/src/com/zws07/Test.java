package com.zws07;

/*
 * ����teacher��test����
 * ������Ϊ��ʽ��������Ҫ����ʵ�Ǹ���Ķ���
 */
public class Test {
	public static void main(String[] args) {
		//����teacher��ķ������ȴ���һ��teacher����
		Teacher t = new Teacher();
		//teacher������ʽ������Student s,���Դ���һ��Student����
		Student s = new Student();
		t.test(s);
	}
	
}
