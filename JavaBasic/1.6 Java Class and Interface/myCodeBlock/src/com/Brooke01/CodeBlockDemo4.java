package com.Brooke01;

public class CodeBlockDemo4 {
	//CoderBlockDemo4的静态代码块
	//执行一次，随着类的加载而加载
	static {
		System.out.println("CoderBlockDemo4的静态代码块执行");
	}
	
	//CoderBlockDemo4的构造代码块
	//不会执行，因为只有创建对象才会执行构造代码块，显然这里没有创建CoderBlockDemo4的对象
	{
		System.out.println("CoderBlockDemo4的静态代码块执行");
	}
	public static void main(String[] args) {
		System.out.println("CodeBlockDemo4主函数执行");
		Coder c1 = new Coder();
		Coder c2 = new Coder();
	}
}

class Coder {
	//Coder的静态代码块
	//执行一次，随着类的加载而加载
	static {
		System.out.println("Coder的静态代码块执行");
	}
	
	//Coder的构造代码块
	//无参构造前执行
	{
		System.out.println("Coder的构造代码块执行");
	}
	
	//Coder的无参构造
	public Coder() {
		System.out.println("Coder的无参构造执行");
	}
}