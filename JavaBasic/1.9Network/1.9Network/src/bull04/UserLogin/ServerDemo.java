package bull04.UserLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/*
 * �����
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//1.���������Socket����
		ServerSocket ss = new ServerSocket(4738);
		//2.������������
		Socket s = ss.accept();
		//3.��ȡ����������,����ת����InputStreamReader���ֽ���s.getInputStream()ת��Ϊ�ַ���
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//��ȡ����
		String userName = br.readLine();
		String userPasswd = br.readLine();
		
		//4.�ж��û��������Ƿ���ȷ
		boolean flag = true;
		//��ȡ���ݿ⼯�ϡ������д洢���������û���Ϣ��
		List<User> userDB = UserDB.getUser();
		//�Դӿͻ��˻�ȡ���û����������½�һ��User����
		User user = new User(userName,userPasswd);
		//��contains�����ж����ݿ⼯�����Ƿ��д˶���,�ǵ���д�û����equals����
		if(userDB.contains(user)) {
			flag = true;
		}
		else {
			flag = false;
		}
		
		//5.�������ݵ��ͻ���
		//��ȡ���������,���ô�ӡ��(Ҳ������BufferedWriter)�����ֽ���s.getOutputStream()ת��Ϊ�ַ���
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		
		if(flag) {
			pw.println("��¼�ɹ�");
		}
		else {
			pw.println("��¼ʧ��");
		}
		
		//6.�ͷ���Դ
		br.close();
		s.close();
		//ss.close();//���Բ��ر�
	}
}
