package bull1711.CopyIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 使用字节流复制文本文件
 */
public class IODemo4 {
	public static void main(String[] args) throws IOException {
		//创建输出流对象
		FileOutputStream fos = new FileOutputStream("IODemo4.txt");
		//创建输入流对象
		FileInputStream fis = new FileInputStream("IODemo2.txt");
		
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
			fos.write(by, 0, len);
			fos.flush();
		}
		
		//释放资源
		fis.close();
		fos.close();
	}
}
