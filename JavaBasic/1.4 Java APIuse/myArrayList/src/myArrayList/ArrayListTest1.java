package myArrayList;

import java.util.ArrayList;

public class ArrayListTest1 {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		
		//����ַ���Ԫ��
		arr.add("÷��");
		arr.add("�����");
		arr.add("������˹");
		
		for(int x=0;x<arr.size();x++) {
			String str = arr.get(x);
			System.out.println(str);
		}
	}
}
