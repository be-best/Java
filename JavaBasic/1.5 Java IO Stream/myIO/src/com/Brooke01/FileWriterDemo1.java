package com.Brooke01;

import java.io.FileWriter;
import java.io.IOException;


public class FileWriterDemo1 {
	public static void main(String[] args) throws IOException {
		//�������������"
		FileWriter fw = new FileWriter("FileWriterDemo1.txt");
		
		//�������������д���ݵķ���
		//дһ���ַ�������
		fw.write("HelloWorld��");
		//����û��д���ļ��ֻд��������
		fw.flush();
		
		
		//flushˢ�»�������������Լ���д����
		fw.write("java");
		fw.flush();
		
		//�ͷ���Դ
		//֪ͨϵͳ�ͷź͸��ļ���ص���Դ
		//close()��ˢ�»�������֪ͨϵͳ�ͷ���Դ�������󲻿�����ʹ�á������޷�����д���ݡ�
		fw.close();
		
	}
}