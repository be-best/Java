package bull03.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class ClientDemo2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建客户端Socket对象
		Socket s  = new Socket(InetAddress.getByName("DESKTOP-ICVMAGQ"),1234);
		//获取输出流对象
		OutputStream os = s.getOutputStream();
		//发送数据
		//String str = "hello java!";
		byte[] data = "hello java!".getBytes();
		os.write(data);
		
		//接收服务端返回的数据
		//获取输入流对象
		InputStream is = s.getInputStream();
		//获取数据,数组就是一个容器,用来放读取的数据
		byte[] datas = new byte[1024];
		int len = is.read(datas);
		
		//输出数据
		System.out.println(new String(datas,0,len));
		
		//释放资源
		os.close();
		s.close();
	}
}
