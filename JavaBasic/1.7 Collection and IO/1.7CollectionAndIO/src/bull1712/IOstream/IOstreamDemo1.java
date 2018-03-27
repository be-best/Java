package bull1712.IOstream;
/*
 * 读取指定目录下的文件并输出到命令行
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class IOstreamDemo1 {
	public static void main(String[] args) throws IOException {
		//需要将字节转换为字符串
		method1();
		//采用OutputStreamWriter创建输出流对象，省去getBytes()转换字符串步骤
		method2();
		//采用BufferedWriter和OutputStreamWriter结合方式，省的自定义"\r\n"换行符
		method3();
	}

	private static void method3() throws FileNotFoundException, IOException {
		//创建输入流对象
		BufferedReader br = new BufferedReader(new FileReader("IODemo2.txt"));
		
		//创建输入流对象
		//方式一：可以先创建OutputStreamWriter对象再创建BufferedWriter对象
		//Writer w = new OutputStreamWriter(System.out);
		//BufferedWriter bw = new BufferedWriter(w);
		
		//方式二：可以直接采用匿名对象方式
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		while((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
		}
		
		//释放资源
		br.close();
		bw.close();
	}

	private static void method2() throws FileNotFoundException, IOException {
		//创建缓冲输入流对象
		BufferedReader br = new BufferedReader(new FileReader("IODemo2.txt"));
		//创建输出流对象
		Writer w = new OutputStreamWriter(System.out);
		
		String line;
		while((line = br.readLine()) != null) {
			w.write(line);
			w.write("\r\n");
		}
		
		//释放资源
		br.close();
		w.close();
	}

	private static void method1() throws FileNotFoundException, IOException {
		//创建缓冲输入流对象
		BufferedReader br = new BufferedReader(new FileReader("IODemo2.txt"));
		//创建输出流对象
		OutputStream os = System.out;
		
		String line;
		while((line = br.readLine()) != null) {
			//getBytes():将字节转换为字符串
			os.write(line.getBytes());
			//换行
			os.write("\r\n".getBytes());
		}
		
		//释放资源
		br.close();
		os.close();
	}
}
