package com.Brooke01;

import java.util.ArrayList;
import java.util.List;

/*
 * List:
 * 		1.����ģ��洢�ĺͶ�ȡ��˳����һ���ģ�
 * 		2.����������
 * 		3.�����ظ���
 * List�����й��ܣ�
 * 		void add(int index.E element)
 * 		E get(int index)
 * 		E remove(int index)
 * 		E set(int index,E element)
 */
public class ListDemo {
	public static void main(String[] args) {
		//�����б����
		List l = new ArrayList();
		//��ָ��������λ�����ָ��Ԫ�أ�void add(int index.E element)
		l.add(0,"hello");
		l.add(0,"world");
		l.add(1,"java");
		for(int x = 0;x < l.size();x++) {
			//E get(int index)
			System.out.println(l.get(x));
		}
		System.out.println("-----------");
		//ɾ��ָ��Ԫ�ز����أ�E remove(int index)
		System.out.println(l.remove(0));
		System.out.println("-----------");
		//��ָ������λ�õ�Ԫ���滻Ϊָ����Ԫ�أ�������ԭ�ȵ�Ԫ�أ�E set(int index,E element)
		System.out.println(l.set(0, "android"));
	}
}
