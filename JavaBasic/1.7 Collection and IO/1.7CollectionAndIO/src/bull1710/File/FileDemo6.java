package bull1710.File;

import java.io.File;

/*
 * 
 */
public class FileDemo6 {
	public static void main(String[] args) {
		//String[] list();���ص�ǰ·���������ļ����ļ�������
		File f1 = new File("a");	
		f1.mkdirs();
		String[] str1 = f1.list();
		for(int x = 0;x < str1.length;x++) {
			System.out.println(str1[x]);
		}
		
		//File[] listFiles();
		File f2 = new File("F:\\JavaProject\\1.7 Collection and IO\\myList");
		File[] str2 = f2.listFiles();
		for(int x = 0;x < str2.length;x++) {
			System.out.println(str2[x]);
		}
		
		//static File[] listRoots();�������е��̷�
		File[] files = File.listRoots();
		for (File file : files) {
			System.out.println(file);
		}
	}
}
