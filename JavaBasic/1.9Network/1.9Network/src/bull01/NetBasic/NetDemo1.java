package bull01.NetBasic;

import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * �鿴��������
 *   cmd:ipconfig/all
 * �鿴IP��ַ��
 * 	 cmd:ipconfig
 */
public class NetDemo1 {
	public static void main(String[] args) throws UnknownHostException {
		//static InetAddress getByName(String host)
		//InetAddress address1 = InetAddress.getByName("DESKTOP-ICVMAGQ");
		InetAddress address = InetAddress.getByName("192.168.102.1");
		//System.out.println(address);
		
		//��ȡ������
		String hostName = address.getHostName();
		//��ȡIP��ַ
		String hostAddress = address.getHostAddress();
		System.out.println(hostName);//DESKTOP-ICVMAGQ
		System.out.println(hostAddress);//192.168.102.1
	}
}
