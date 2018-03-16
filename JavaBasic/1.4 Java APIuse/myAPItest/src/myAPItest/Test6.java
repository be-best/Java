package myAPItest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.internal.ws.util.StringUtils;
/*
 * 项目根路径下有text.txt文件，内容如下：
 * 我爱湖人队
 * 123456
 * 利用IO流的知识读取text.txt文件的内容反转后写入text.txt文件中
 */

public class Test6 {
	public static void main(String[] args) throws IOException {
		//创建输入流对象
		BufferedReader br = new BufferedReader(new FileReader("text.txt")); 
		String line;
		//创建集合
		ArrayList<String> array = new ArrayList<String>();
		while((line = br.readLine()) != null) {
				char[] chs = line.toCharArray();
				for(int start=0,end=chs.length-1;start<end;end--,start++) {
					char temp = chs[start];
					chs[start] = chs[end];
					chs[end] = temp;
				}
				
				String str = new String(chs);
				//String str = chs.toString();
				array.add(str);
				
			}	
		
		br.close();
		//创建输出流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt"));
		for(int x=0;x<array.size();x++) {
			bw.write(array.get(x));
			bw.newLine();
			}
			
		//释放资源
		bw.close();
	}
}
