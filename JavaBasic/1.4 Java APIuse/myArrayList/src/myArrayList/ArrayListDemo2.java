package myArrayList;

import java.util.ArrayList;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("hello");
		arr.add("world");
		arr.add("Java");
		arr.add("very");
		arr.add("good");
		
		//��ȡԪ�� public E get(int index)
		System.out.println("λ��0��Ԫ���ǣ�"+arr.get(0));
		System.out.println("λ��3��Ԫ���ǣ�"+arr.get(3));
		System.out.println("------------");
		
		//public int size():���ؼ����е�Ԫ�ظ���
		System.out.println(arr.size());
		System.out.println("------------");
		
		//ɾ��Ԫ��һ��public boolean remove(Object o)��ɾ��ָ��Ԫ�أ������Ƿ�ɾ���ɹ�
		System.out.println("ɾ����hello��"+arr.remove("hello"));
		System.out.println("ɾ����hello��"+arr.remove("hello"));
		System.out.println("��ʱ��arr:"+arr);
		System.out.println("------------");
		
		//ɾ��Ԫ�ض���public E remove(int index)��ɾ��ָ����Ԫ�أ����ر�ɾ����Ԫ��
		System.out.println("ɾ������ʱλ��Ϊһ��Ԫ�أ�"+arr.remove(1));
		System.out.println("��ʱ��arr:"+arr);
		System.out.println("------------");
		
		//�޸�Ԫ�أ�public E set(int index,E element);�޸�ָ����������Ԫ�أ����ر��޸ĵ�Ԫ��
		System.out.println("�޸�λ��Ϊ����Ԫ��Ϊperfect��"+arr.set(2, "perfect"));
		System.out.println("��ʱ��arr:"+arr);
		
	}
}
