package bull1710.File;

import java.io.File;

/*
 * ����ɾ��ָ��Ŀ¼�µ��ļ���
 *   ��Ҫ��ɾ����Ŀ¼�µ��ļ�
 */
public class FileTest2 {
	public static void main(String[] args) {
		File f = new File("f:\\a");
		method(f);
	}
	public static void method(File f) {
		if(f.isDirectory()) {
			File[] f1 = f.listFiles();
			for (File file : f1) {
				//ɾ���ļ�
				if(file.isFile()) {
					System.out.println(file.getName());
					file.delete();
				}
				//������ļ�����Ҫ������ɾ�����ļ�
				else if(file.isDirectory()) {
					method(file);
				}
			}
			//ɾ���Լ�
			System.out.println(f.getName());
			f.delete();
		}
	}
}
