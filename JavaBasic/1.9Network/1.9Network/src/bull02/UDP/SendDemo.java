package bull02.UDP;
/*
 * 使用UDP协议发送协议：
 * 	创建发送端Socket对象
 * 	创建数据并打包
 * 	发送数据
 * 	释放资源
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//创建发送端Socket对象
		DatagramSocket ds = new DatagramSocket();
		
		//创建数据并打包
		/*
		 * DatagramPacket:此类表示数据包
		 * 数据byte[]
		 * 设备地址ip
		 * 进程的地址端口号
		 */
		//1.数据byte[],转为字节
		String str = "hello world";
		byte[] by = str.getBytes();
		int length = by.length;
		//2.接收设备的ip地址
		InetAddress address = InetAddress.getByName("DESKTOP-ICVMAGQ");//发送给指定设备
		//3.进程的地址端口号
		int port = 8888;
		//打包
		DatagramPacket dp = new DatagramPacket(by, length, address,port);
		
		//发送数据
		ds.send(dp);
		//释放资源
		ds.close();
	}
}
