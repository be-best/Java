package bull02.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendDemo2 {
	public static void main(String[] args) throws IOException {
		//创建Scoket对象
		DatagramSocket ds = new DatagramSocket();
		
		//打包数据
		//数据
		byte[] by = "hello java".getBytes();
		//ip
		InetAddress address = InetAddress.getByName("DESKTOP-ICVMAGQ");
		//端口号
		int port = 8888;
		DatagramPacket dp = new DatagramPacket(by,by.length,address,8888);
		
		//发送数据
		ds.send(dp);
		//释放资源
		ds.close();
	}
}
