package bull02.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendDemo2 {
	public static void main(String[] args) throws IOException {
		//����Scoket����
		DatagramSocket ds = new DatagramSocket();
		
		//�������
		//����
		byte[] by = "hello java".getBytes();
		//ip
		InetAddress address = InetAddress.getByName("DESKTOP-ICVMAGQ");
		//�˿ں�
		int port = 8888;
		DatagramPacket dp = new DatagramPacket(by,by.length,address,8888);
		
		//��������
		ds.send(dp);
		//�ͷ���Դ
		ds.close();
	}
}
