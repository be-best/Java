package bull02.socket;

import java.net.ServerSocket;
import java.net.Socket;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MyServer {
	
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("conf/server.xml");
		//�������ļ��л�ȡ�˿ں�
		Element element = (Element) document.selectSingleNode("//Connector['@port']");
		String port = element.attributeValue("port");
		// ServerSocket ������Լ����˿�
		ServerSocket serversocket = new ServerSocket(Integer.parseInt(port));
		//ServerSocket serversocket = new ServerSocket(8888);
		while(true) {
			Socket socket = serversocket.accept();	// �ȴ��ͻ��˵���������һ��������������ͽ������������ؿͻ��˶���
			//System.out.println(socket.getInetAddress());
			// һ���пͻ������ʣ� ����һ�����߳�ȥ�ṩ���� main�̼߳����ȴ���һ���ͻ�������
			new Thread(new MyService(socket)).start();

		}
	}

}

