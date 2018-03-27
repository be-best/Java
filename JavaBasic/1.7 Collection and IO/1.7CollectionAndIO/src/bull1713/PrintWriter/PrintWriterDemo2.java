package bull1713.PrintWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 使用打印流复制文件
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws IOException {
		//创建输入流对象
		BufferedReader br = new BufferedReader(new FileReader("IODemo2.txt"));
		//创建打印流对象
		//实现自动刷新
		PrintWriter pw = new PrintWriter(new FileWriter("pwd2.txt"),true);
		
		String line;
		while((line = br.readLine()) != null) {
			//用println方法实现自动换行
			pw.println(line);
			//因为打印流自动刷新，所以这边省去了刷新的步骤
		}
		br.close();
		pw.close();
	}
}
