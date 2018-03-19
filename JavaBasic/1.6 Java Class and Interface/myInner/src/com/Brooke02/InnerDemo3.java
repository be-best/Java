package com.Brooke02;
/*
 * 匿名内部类
 */
public class InnerDemo3 {
	public static void main(String[] args) {
		Outer out = new Outer();
		out.function();
	}
}

//接口
interface Inner {
	public void method();
}

//外部类
class Outer {
	public void function() {
		//匿名内部类方式1
		new Inner() {

			@Override
			public void method() {
				System.out.println("匿名内部类方式1");
				
			}
			
		}.method();;
	
		//匿名内部类方式2
		Inner in = new Inner() {

			@Override
			public void method() {
				System.out.println("匿名内部类方式2");
				
			}
			
		};
		in.method();
	}
}