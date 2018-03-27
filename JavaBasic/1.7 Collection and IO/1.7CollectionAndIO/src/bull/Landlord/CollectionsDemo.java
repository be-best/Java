package bull.Landlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Collections:
 * 		Collections��Collection������
 * 		Collection�Ǽ�����ϵ����㣬�����˼�����ϵ�Ĺ���
 * 		Collections��һ�������࣬�����������ڲ���Collection
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		method1();
		System.out.println("-------------------");
		method2();
		System.out.println("-------------------");
		method3();
		System.out.println("-------------------");
		method4();
		System.out.println("-------------------");
		method5();
	}

	private static void method5() {
		//static void swap(List list,int i,int j);��ָ���б��е�������������λ�û���
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		//����û�ǰ�б�
		System.out.println(list);
		Collections.swap(list, 0, 3);
		//����û����б�
		System.out.println(list);
	}

	private static void method4() {
		//static void shuffle(List list);����û�
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("java");
		Collections.shuffle(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}

	private static void method3() {
		//static void fill(List list,Object obj);ʹ��ָ���������ָ���б������Ԫ��
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("hello");
		list.add("world");
		Collections.fill(list, "android");
		System.out.println(list);
	}

	private static void method2() {
		//static void copy(List dest,List src);��Դ�б��е����ݸ��ǵ�Ŀ���б�
		                    //Ŀ���б�	               Դ�б�
		//Ŀ���б���С��Դ�б�
		//����Դ�б�
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("java");
		//����Ŀ���б�
		List<String> list1 = new ArrayList<String>();
		list1.add("");
		list1.add("");
		list1.add("");
		Collections.copy(list1, list);
		System.out.println(list1);
	}

	private static void method1() {
		//static int binarySearch(List list,Object key)ʹ�ö��ֲ��ҷ�����ָ��Ԫ����ָ���б������λ��
		//�����б����
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int index = Collections.binarySearch(list, 3);
		System.out.println(index);
	}
}
