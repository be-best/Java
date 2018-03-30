package bull03.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务端
 * 
 * TCP接收端：
 * 	创建接收端Socket对象
 *  监听（阻塞）
 *  获取输入流对象
 *  获取数据
 *  输出数据
 *  释放资源	
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//创建接收端Socket对象
		ServerSocket ss = new ServerSocket(10000);
		//监听（阻塞）
		Socket s = ss.accept();
		//获取输入流对象
		InputStream is = s.getInputStream();
		//获取数据
		//获取ip
		InetAddress address = s.getInetAddress();
		//获取字节长度，数组就是一个容器,用来放读取的数据
		byte[] data = new byte[1024];
		int len = is.read(data);
		//输出数据
		System.out.println("sender-->"+address.getHostAddress());
		System.out.println(new String(data,0,len));
		
		//释放资源
		s.close();
		//ss.close();//可以不释放，服务端一般不关闭
	}
}
