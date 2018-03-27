package bull1712.IOstream;
/*
 * ��ȡָ��Ŀ¼�µ��ļ��������������
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class IOstreamDemo1 {
	public static void main(String[] args) throws IOException {
		//��Ҫ���ֽ�ת��Ϊ�ַ���
		method1();
		//����OutputStreamWriter�������������ʡȥgetBytes()ת���ַ�������
		method2();
		//����BufferedWriter��OutputStreamWriter��Ϸ�ʽ��ʡ���Զ���"\r\n"���з�
		method3();
	}

	private static void method3() throws FileNotFoundException, IOException {
		//��������������
		BufferedReader br = new BufferedReader(new FileReader("IODemo2.txt"));
		
		//��������������
		//��ʽһ�������ȴ���OutputStreamWriter�����ٴ���BufferedWriter����
		//Writer w = new OutputStreamWriter(System.out);
		//BufferedWriter bw = new BufferedWriter(w);
		
		//��ʽ��������ֱ�Ӳ�����������ʽ
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		while((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
		}
		
		//�ͷ���Դ
		br.close();
		bw.close();
	}

	private static void method2() throws FileNotFoundException, IOException {
		//������������������
		BufferedReader br = new BufferedReader(new FileReader("IODemo2.txt"));
		//�������������
		Writer w = new OutputStreamWriter(System.out);
		
		String line;
		while((line = br.readLine()) != null) {
			w.write(line);
			w.write("\r\n");
		}
		
		//�ͷ���Դ
		br.close();
		w.close();
	}

	private static void method1() throws FileNotFoundException, IOException {
		//������������������
		BufferedReader br = new BufferedReader(new FileReader("IODemo2.txt"));
		//�������������
		OutputStream os = System.out;
		
		String line;
		while((line = br.readLine()) != null) {
			//getBytes():���ֽ�ת��Ϊ�ַ���
			os.write(line.getBytes());
			//����
			os.write("\r\n".getBytes());
		}
		
		//�ͷ���Դ
		br.close();
		os.close();
	}
}
