package com.Brooke01;

import java.util.LinkedList;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

/*
 * List的常用子类：
 * 		ArrayList
 * 			底层是数组，查询快增删慢
 * 		LinkedList
 * 			底层是链表，查询慢增删快
 * 			void addFirst(E,e)
 * 			void addLast(E,e)
 * 			E getFiest()
 * 			E getLast()
 * 			E removeFirst()
 * 			E removeLast()
 */
public class ListDemo2 {
	public static void main(String[] args) {
		//创建对象
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
