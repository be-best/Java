package bull1713.PrintWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * ʹ�ô�ӡ�������ļ�
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws IOException {
		//��������������
		BufferedReader br = new BufferedReader(new FileReader("IODemo2.txt"));
		//������ӡ������
		//ʵ���Զ�ˢ��
		PrintWriter pw = new PrintWriter(new FileWriter("pwd2.txt"),true);
		
		String line;
		while((line = br.readLine()) != null) {
			//��println����ʵ���Զ�����
			pw.println(line);
			//��Ϊ��ӡ���Զ�ˢ�£��������ʡȥ��ˢ�µĲ���
		}
		br.close();
		pw.close();
	}
}
