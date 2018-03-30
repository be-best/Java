package bull02.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveDemo2 {
	public static void main(String[] args) throws IOException {
		//创建Socket对象,端口 号应该和发送端一致
		DatagramSocket ds = new DatagramSocket(8888);
		//接收数据，数组就是一个容器,用来放读取的数据
		byte[] by = new byte[1024];
		DatagramPacket dp = new DatagramPacket(by,by.length);
		ds.receive(dp);
		//解析数据
		InetAddress address = dp.getAddress();
		byte[] data = dp.getData();
		int length = dp.getLength();
		
		System.out.println("sender-->"+address.getHostAddress());
		System.out.println(new String(data,0,length));
		//释放资源
		ds.close();
	}
}
