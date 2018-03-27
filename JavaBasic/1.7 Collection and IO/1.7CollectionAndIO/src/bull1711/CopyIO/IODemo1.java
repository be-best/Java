package bull1711.CopyIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 文件的复制
 */
public class IODemo1 {
	public static void main(String[] args) throws IOException {
		//创建输出流对象
		FileWriter fw = new FileWriter("IODemo1.txt");
		//创建输入流对象
		FileReader fr = new FileReader("RecursiveDemo1.java");
		
		//一次读写一个字符
		int ch;
		while((ch = fr.read()) != -1) {
			fw.write(ch);
			fw.flush();
		}
		
		//一次读写一个字符数组
		char[] str = new char[1024];
		int len;
		while((len = fr.read(str)) != -1) {
			fw.write(str,0,len);
			fw.flush();
		}
		//释放资源
		fw.close();
		fr.close();
	}
}
