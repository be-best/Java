package com.Brooke01;

import java.util.LinkedList;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

/*
 * List�ĳ������ࣺ
 * 		ArrayList
 * 			�ײ������飬��ѯ����ɾ��
 * 		LinkedList
 * 			�ײ���������ѯ����ɾ��
 * 			void addFirst(E,e)
 * 			void addLast(E,e)
 * 			E getFiest()
 * 			E getLast()
 * 			E removeFirst()
 * 			E removeLast()
 */
public class ListDemo2 {
	public static void main(String[] args) {
		//��������
		LinkedList l = new LinkedList();
		l.add("hello");
		l.add("world");
		l.addFirst("java");
		l.addLast("android");
		System.out.println(l);
		System.out.println(l.removeFirst());
		System.out.println(l.removeLast());
		System.out.println(l.getFirst());
		System.out.println(l.getLast());
	}
}
