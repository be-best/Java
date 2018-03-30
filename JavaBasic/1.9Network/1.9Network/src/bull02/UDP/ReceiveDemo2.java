package bull02.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveDemo2 {
	public static void main(String[] args) throws IOException {
		//����Socket����,�˿� ��Ӧ�úͷ��Ͷ�һ��
		DatagramSocket ds = new DatagramSocket(8888);
		//�������ݣ��������һ������,�����Ŷ�ȡ������
		byte[] by = new byte[1024];
		DatagramPacket dp = new DatagramPacket(by,by.length);
		ds.receive(dp);
		//��������
		InetAddress address = dp.getAddress();
		byte[] data = dp.getData();
		int length = dp.getLength();
		
		System.out.println("sender-->"+address.getHostAddress());
		System.out.println(new String(data,0,length));
		//�ͷ���Դ
		ds.close();
	}
}
