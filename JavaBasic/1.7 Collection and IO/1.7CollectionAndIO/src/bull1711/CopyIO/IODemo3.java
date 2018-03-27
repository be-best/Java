package bull1711.CopyIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 采用字节流复制图片
 * 
 * 二进制文件（使用windows自带记事本读不懂的）只能用字节流进行复制
 * 文本文件既可用字节流也可用字符流
 */
public class IODemo3 {
	public static void main(String[] args) throws IOException {
		//创建输入流对象
		FileInputStream fis = new FileInputStream("1.jpg");
		//创建输出流对象
		FileOutputStream fos = new FileOutputStream("copyD3.jpg");
		
		//一次读写一个字节数组
		byte[] by = new byte[1024];
		int len;
		while((len = fis.read(by)) != -1) {
			fos.write(by,0,len);
		}
		
		//释放资源
		fis.close();
		fos.close();
	}

}
