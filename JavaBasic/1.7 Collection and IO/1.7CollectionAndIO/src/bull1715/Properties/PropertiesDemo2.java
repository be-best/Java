package bull1715.Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/*
 * Properties和IO流结合的功能：
 * 		void load(Reader reader);
 * 		void list(PrintWriter list);只能写打印流
 * 		void store(Writer writer,String comments);其中Sring comments是对文件数据的描述
 */
public class PropertiesDemo2 {
	public static void main(String[] args) throws IOException {
		//写数据方式一
		method1();
		//读数据
		method2();
		//写数据方式二
		method3();
	}

	private static void method3() throws IOException {
		//创建属性列表对象
		Properties prop = new Properties();
		//创建输出流对象
		FileWriter fw = new FileWriter("PD2.txt");
		//添加映射对象
		prop.setProperty("张一", "0001");
		prop.setProperty("李二", "0002");
		prop.setProperty("王三", "0003");
		//void store(Writer writer,String comments);其中Sring comments是对文件数据的描述
		prop.store(fw, "PropertiesDemo2");
		//释放资源
		fw.close();
	}

	private static void method2() throws FileNotFoundException, IOException {
		//创建属性列表对象
		Properties prop = new Properties();
		//创建输入流对象
		FileReader fr = new FileReader("PD2.txt");
		
		prop.load(fr);
		//释放资源
		fr.close();
		System.out.println(prop);
	}

	private static void method1() throws FileNotFoundException {
		//创建属性列表对象
		Properties prop = new Properties();
		//创建打印流对象
		PrintWriter pw = new PrintWriter("PD2.txt");
		
		prop.setProperty("张三", "001");
		prop.setProperty("李四", "002");
		prop.setProperty("王五", "003");
		//void list(PrintWriter list);
		prop.list(pw);
		//释放资源
		pw.close();
	}
}
