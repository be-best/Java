package com.Brooke01;

import java.util.ArrayList;
import java.util.List;

/*
 * List:
 * 		1.有序的（存储的和读取的顺序是一样的）
 * 		2.有整数索引
 * 		3.允许重复的
 * List的特有功能：
 * 		void add(int index.E element)
 * 		E get(int index)
 * 		E remove(int index)
 * 		E set(int index,E element)
 */
public class ListDemo {
	public static void main(String[] args) {
		//创建列表对象
		List l = new ArrayList();
		//在指定的索引位置添加指定元素，void add(int index.E element)
		l.add(0,"hello");
		l.add(0,"world");
		l.add(1,"java");
		for(int x = 0;x < l.size();x++) {
			//E get(int index)
			System.out.println(l.get(x));
		}
		System.out.println("-----------");
		//删除指定元素并返回：E remove(int index)
		System.out.println(l.remove(0));
		System.out.println("-----------");
		//将指定索引位置的元素替换为指定的元素，并返回原先的元素；E set(int index,E element)
		System.out.println(l.set(0, "android"));
	}
}
