package bull04.UserLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class ClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.创建客户端Socket对象
		Socket s = new Socket(InetAddress.getByName("DESKTOP-ICVMAGQ"),4738);
		//2.获取用户名密码
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String userName = br.readLine();
		System.out.println("请输入密码：");
		String userPasswd = br.readLine();
		
		//3.获取输出流对象,采用打印流(也可以用BufferedWriter)，打印流可以将字节输出流(s.getOutputStream())转换为字符输出流
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		
		//4.发送数据
		pw.println(userName);
		pw.println(userPasswd);
		
		//5.接收数据
		//获取输入流对象,采用转换流InputStreamReader将字节流转换为字符流
		BufferedReader serverBr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String result = serverBr.readLine();
		System.out.println(result);
		
		//6.释放资源
		s.close();
		br.close();
		serverBr.close();
	}
}
