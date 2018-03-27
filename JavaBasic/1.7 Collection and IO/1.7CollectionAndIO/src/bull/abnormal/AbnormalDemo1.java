package bull.abnormal;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 方式一：
 * try {
 * 		有可能出现问题的代码；
 * }catch(ArithmeticException ae) {
 * 		处理异常；
 * }
 * 
 * try...catch的执行顺序：
 * 		先执行try语句发现异常后异常后面的代码不执行，直接跳到catch语句,然后try...catch执行结束;
 * 		如果没有异常则执行try语句，不执行catch语句;
 * 
 * 方式二：抛异常
 * 		当我们不想处理或没能力处理时，可以选择抛异常，谁调用方法谁处理异常
 * 		使用关键字throws在方法的声明抛出异常
 */
public class AbnormalDemo1 {
	public static void main(String[] args) throws IOException {
		method1();
		method2();
	}

	private static void method2() throws IOException {
		FileWriter fw = new FileWriter("test.txt");
	}

	private static void method1() {
		try {
			System.out.println(1+2);
			System.out.println(9/0);
			System.out.println(1+1);
		} catch(ArithmeticException ae) {
			System.out.println("除数不能为0");
		}
		System.out.println("结束");
	}
}
