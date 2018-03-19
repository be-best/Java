package myPolymorphism;
/*
 * 多态的成员特点：
 * 		成员变量：编译时看左边，运行时看左边
 * 		成员方法：编译时看左边，运行时看右边
 * 		静态方法:编译时看左边，运行时看左边
 */
public class PolymorphismDemo2 {
	public static void main(String[] args) {
		Dad d = new Son();
		int num = d.num;
		System.out.println(num);
		d.show();
		d.stat();//使用变量调用静态方法，其实相当于变量类型的类去调用
	}
}

class Dad {
	int num = 10;
	public void show() {
		System.out.println("我是父类成员方法");
	}
	
	public static void stat() {
		System.out.println("我是父类静态方法");
	}
}

class Son extends Dad {
	int num = 20;
	public void show() {
		System.out.println("我是子类成员方法");
	}
	
	public static void stat() {
		System.out.println("我是子类静态方法");
	}
}