package bull02.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * UDP����Э�飺
 * 	��������Socket����
 * 	��������
 * 	��������
 *  �������
 *  �ͷ���Դ
 */

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		//��������Socket����,8888�Ƕ˿ں�
		DatagramSocket ds = new DatagramSocket(8888);
		
		//��������,����һ����Ȼ��������ݣ��������һ������,�����Ŷ�ȡ������
		byte[] by = new byte[1024];
		DatagramPacket dp = new DatagramPacket(by, by.length);
		ds.receive(dp);
		
		//��������
		//InetAddress getAddress();��ȡ��ַ  
		//byte[] getData();��ȡ����  
		//int getLength();���ݳ���  
		InetAddress address = dp.getAddress();
		byte[] data = dp.getData();
		int length = dp.getLength();
		
		//�������
		//��ȡIP��ַ
		System.out.println("sender--->"+address.getHostAddress());
		//��ȡ����,byte����ת��ΪString��ʽ
		System.out.println(new String(data,0,length));
		
		//�ͷ���Դ
		ds.close();
	}
}
