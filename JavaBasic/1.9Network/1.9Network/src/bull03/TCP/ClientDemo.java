package bull03.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 * 
 * TCP发送数据：
 * 	创建发送端Socket对象
 *  获取输出流对象
 *  发送数据
 *  释放资源
 */
public class ClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建发送端Socket对象
		Socket s = new Socket(InetAddress.getByName("DESKTOP-ICVMAGQ"), 10000);
		
		//获取输出流对象
		OutputStream os = s.getOutputStream();
		
		//发送数据
		byte[] data = "hello java world".getBytes();
		os.write(data);
	
		
		//释放资源
		os.close();//可写可不写，因为Socket也会帮忙释放
		s.close();
	}
}
