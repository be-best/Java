package com.Brooke01;
/*
 * 局部内部类：
 * 		位置和局部变量一样，位于方法内
 */
public class InnerDemo2 {
	public static void main(String[] args) {
		Outer1 out = new Outer1();
		out.method();
	}
}

//外部类
class Outer1 {
	int num;
	public void method() {
		//局部内部类
		class Inners {
			public void function() {
				System.out.println("Outer1-function");
			}
		}
		//创建Inners对象
		Inners in = new Inners();
		in.function();
	}
}