package myArrayList;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		//�������϶���
		ArrayList<String> arr = new ArrayList<String>();
		
		//add(E e)���Ԫ��
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
