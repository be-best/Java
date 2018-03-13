package myArrayList;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		//创建集合对象
		ArrayList<String> arr = new ArrayList<String>();
		
		//add(E e)添加元素
		arr.add("hello");
		arr.add("world");
		arr.add("Java");
		System.out.println(arr);
		
		//add(int Index,E element)
		arr.add(0,"very");
		System.out.println(arr);
		arr.add(1,"good");
		System.out.println(arr);
	}

}
