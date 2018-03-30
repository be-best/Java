package bull02.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * UDP接收协议：
 * 	创建接收Socket对象
 * 	接收数据
 * 	解析数据
 *  输出数据
 *  释放资源
 */

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		//创建接收Socket对象,8888是端口号
		DatagramSocket ds = new DatagramSocket(8888);
		
		//接收数据,创建一个包然后接收数据，数组就是一个容器,用来放读取的数据
		byte[] by = new byte[1024];
		DatagramPacket dp = new DatagramPacket(by, by.length);
		ds.receive(dp);
		
		//解析数据
		//InetAddress getAddress();获取地址  
		//byte[] getData();获取数据  
		//int getLength();数据长度  
		InetAddress address = dp.getAddress();
		byte[] data = dp.getData();
		int length = dp.getLength();
		
		//输出数据
		//获取IP地址
		System.out.println("sender--->"+address.getHostAddress());
		//获取数据,byte数组转化为String形式
		System.out.println(new String(data,0,length));
		
		//释放资源
		ds.close();
	}
}
