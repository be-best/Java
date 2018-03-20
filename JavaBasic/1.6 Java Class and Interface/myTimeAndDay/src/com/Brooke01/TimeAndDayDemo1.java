package com.Brooke01;
/*
 * ʱ�������
 */
public class TimeAndDayDemo1 {
	public static void main(String[] args) {
		method1();
		method2();
		method3();
		method4();
	}

	private static void method4() {
		/*
		 * static void gc();��������
		 * ����ʱ�����finalize()����,����д��������жϻ������
		 */
		new Demo();
		System.gc();
		System.out.println("-------");
	}

	private static void method3() {
		/*
		 * static void exit(int status):��ֹ�����
		 */
		for(int x = 0;x < 1000;x++) {
			System.out.println(x);
			if(x == 99) {
				System.exit(0);
			}
		}
		System.out.println("-------");
	}

	private static void method2() {
		/*
		 * static long currentTimeMillis():�Ժ���ֵ���ص�ǰϵͳʱ��
		 * �����1970-1-1 00:00:00
		 * 1970-1-1 00:00:01  ����1000ms
		 */
		long start = System.currentTimeMillis();
		for(int x = 0;x <1000;x++) {
			System.out.println(x);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("-------");
	}

	private static void method1() {
		/*
		 * static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
		 * ��������
		 * Դ����
		 * ԭ������ʼ��ַ
		 * Ŀ������
		 * Ŀ��������ʼ��ַ
		 * ���ճ���
		 */
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = new int[5];
		System.arraycopy(arr1, 0, arr2, 0, 3);
		for(int x = 0;x < arr2.length;x++) {
			System.out.print(arr2[x]);
		}
		System.out.println("-------");
	}
}


class Demo {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("��������");
	}
}