package com.Brooke01;
/*
 * 时间和日期
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
		 * static void gc();垃圾回收
		 * 回收时会调用finalize()方法,可重写这个方法判断回收与否
		 */
		new Demo();
		System.gc();
		System.out.println("-------");
	}

	private static void method3() {
		/*
		 * static void exit(int status):终止虚拟机
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
		 * static long currentTimeMillis():以毫秒值返回当前系统时间
		 * 相对于1970-1-1 00:00:00
		 * 1970-1-1 00:00:01  返回1000ms
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
		 * 复制数组
		 * 源数组
		 * 原数组起始地址
		 * 目标数组
		 * 目标数组起始地址
		 * 接收长度
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
		System.out.println("垃圾回收");
	}
}