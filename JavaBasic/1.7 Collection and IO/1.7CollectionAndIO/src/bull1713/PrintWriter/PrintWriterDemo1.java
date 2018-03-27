package bull1713.PrintWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 打印流的特有功能
 * 		自动换行,使用println()方法实现自动换行
 * 		自动刷新
 * 
 * 创建FileWriter对象时的boolean参数是是否追加
 * 创建PrintWriter对象时的boolean参数是是否自动刷新
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException {
		method1();
		method2();
		
	}

	private static void method2() throws IOException {
		//创建打印流对象
		//true代表的是自动刷新
		PrintWriter pw = new PrintWriter(new FileWriter("pwd.txt"),true);
		pw.println("java");
		pw.println("android");
		//省略刷新步骤
		//pw.flush();
		
		pw.close();
	}

	private static void method1() throws FileNotFoundException {
		//创建打印流对象
		PrintWriter pw = new PrintWriter("pwd.txt");
		
		pw.println("hello");
		pw.println("world");
		//释放资源
		pw.close();
	}
}
