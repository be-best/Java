package bull01.NetBasic;

import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * 查看主机名：
 *   cmd:ipconfig/all
 * 查看IP地址：
 * 	 cmd:ipconfig
 */
public class NetDemo1 {
	public static void main(String[] args) throws UnknownHostException {
		//static InetAddress getByName(String host)
		//InetAddress address1 = InetAddress.getByName("DESKTOP-ICVMAGQ");
		InetAddress address = InetAddress.getByName("192.168.102.1");
		//System.out.println(address);
		
		//获取主机名
		String hostName = address.getHostName();
		//获取IP地址
		String hostAddress = address.getHostAddress();
		System.out.println(hostName);//DESKTOP-ICVMAGQ
		System.out.println(hostAddress);//192.168.102.1
	}
}
