package bull1710.File;

import java.io.File;

/*
 * �������ָ��Ŀ¼�µ�����java�ļ�����������Ŀ¼��
 */
public class FileTest1 {
	public static void main(String[] args) {
		File f = new File("src\\bull1710\\File");
		method(f);
	}
	
	public static void method(File f) {
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				if(file.getName().endsWith(".java")) {
					System.out.println(file.getName());
				}
				//���file�����ļ������ļ���������ݹ飻
				if(file.isDirectory()) {
					method(file);
				}
			}
		}
	}
}
