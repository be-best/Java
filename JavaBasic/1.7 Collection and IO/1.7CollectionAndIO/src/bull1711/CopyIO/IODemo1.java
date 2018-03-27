package bull1711.CopyIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * �ļ��ĸ���
 */
public class IODemo1 {
	public static void main(String[] args) throws IOException {
		//�������������
		FileWriter fw = new FileWriter("IODemo1.txt");
		//��������������
		FileReader fr = new FileReader("RecursiveDemo1.java");
		
		//һ�ζ�дһ���ַ�
		int ch;
		while((ch = fr.read()) != -1) {
			fw.write(ch);
			fw.flush();
		}
		
		//һ�ζ�дһ���ַ�����
		char[] str = new char[1024];
		int len;
		while((len = fr.read(str)) != -1) {
			fw.write(str,0,len);
			fw.flush();
		}
		//�ͷ���Դ
		fw.close();
		fr.close();
	}
}
