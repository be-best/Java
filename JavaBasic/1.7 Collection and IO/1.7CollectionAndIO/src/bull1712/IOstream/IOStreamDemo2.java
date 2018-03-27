package bull1712.IOstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * 读取键盘录入数据并存储到指定文件下
 * 
 * 转换流：InputStreamReader
 *    	将字节输入流转换为字符输入流		
 */
public class IOStreamDemo2 {
	public static void main(String[] args) throws IOException {
		//采用字节数组方式
		method1();
		//采用InputStreamReader，将字节输入流转换为字符输入流	
		method2();
	}

	private static void method2() throws IOException {
		//创建输入流对象
		//InputStream is = System.in;
		Reader r = new InputStreamReader(System.in);
		//创建输出流对象
		FileWriter fw = new FileWriter("a.txt");
		
		char[] chs = new char[1024];
		int len;
		while((len = r.read(chs)) != -1) {
			fw.write(chs, 0, len);
			fw.flush();
		}
		//释放资源
		fw.close();
		r.close();
	}

	private static void method1() throws IOException {
		//创建输入流对象
		InputStream is = System.in;
		//创建输出流对象
		FileWriter fw = new FileWriter("a.txt");
		
		byte[] by = new byte[1024];
		int len;
		while((len = is.read(by)) != -1) {
			//new String();将字节数组转换为字符串.注意(by,0,len)的格式
			fw.write(new String(by,0,len));
			fw.flush();
		}
		//释放资源
		fw.close();
		is.close();
	}
}
