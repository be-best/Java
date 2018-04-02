package bull06.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import org.junit.Test;

/*
 * ������д���ļ�
 */
public class PropertiesDemo_02 {
	@Test
	public void method1() throws Exception {
		//��������
		Properties prop = new Properties();
		//��������
		prop.setProperty("k1", "v1");
		prop.setProperty("k2", "v2");
		prop.setProperty("k3", "v3");
		
		//������д���ļ�
		Writer writer = new OutputStreamWriter(new FileOutputStream("prop.txt"),"UTF-8");
		prop.store(writer, "this is file-introduce");
		writer.close();
		
		//����BufferedWriter��ʽ
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("prop1.txt"),"UTF-8"));
//		prop.store(bw, "����");
//		bw.close();
	}
	
	@Test
	public void method2() throws Exception, FileNotFoundException {
		//��������
		Properties prop = new Properties();
		
		//ͨ��properties���������
		Reader reader = new InputStreamReader(new FileInputStream("prop.txt"),"UTF-8");
		prop.load(reader);
		reader.close();
		
		//�������������̨
		for (String name : prop.stringPropertyNames()) {
			String value = prop.getProperty(name);
			System.out.println(name + "@" + value);
		}
	}
}
