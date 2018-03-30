package bull03.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务端
 */
public class ServerDemo2 {
	public static void main(String[] args) throws IOException {
		//创建服务端Socket对象
		ServerSocket ss = new ServerSocket(1234);
		//监听（阻塞）
		Socket s = ss.accept();
		//获取输入流对象
		InputStream is = s.getInputStream();
		//获取数据
		//ip
		InetAddress address = s.getInetAddress();
		//数据，数组就是一个容器,用来放读取的数据
		byte[] data = new byte[1024];
		int len = is.read(data);
		//输出数据
		System.out.println(new String(data,0,len));
		
		//发送数据返回客户端
		//获取输出流对象
		OutputStream os = s.getOutputStream();
		//转换成大写并发送数据
		String str = new String(data,0,len);
		String stru = str.toUpperCase();
		os.write(stru.getBytes());
		
		//释放资源
		s.close();
		//ss.close();//服务端一般不关闭
	}
}
