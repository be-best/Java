package bull1711.CopyIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 字节流
 */
public class IODemo2 {
	public static void main(String[] args) throws IOException {
		//创建字节输入流对象
		FileInputStream fis = new FileInputStream("RecursiveDemo1.java");
		//创建字节输出流对象
		FileOutputStream fos = new FileOutputStream("IODemo2.txt");
		
		//一次读写一个字节
		int ch;
		while((ch = fis.read()) != -1) {
			fos.write(ch);
			fos.flush();
		}
		
		//一次读写一个字节数组
		byte[] by = new byte[1024];
		int len;
		while((len = fis.read(by)) != -1) {
			fos.write(by,0,len);
			fos.flush();
		}
		
		fis.close();
		fos.close();
	}
}
