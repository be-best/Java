package bull1710.File;

import java.io.File;
import java.io.IOException;

/*
 * File������ɾ��
 * 
 * �������ܣ�
 * 		boolean createNewFile();
 * 		boolean mkdir();
 * 		boolean mkdirs();
 * 
 * ɾ�����ܣ�
 * 		boolean delect();
 * 		ע�⣺ɾ��һ���ļ� ʱ������ļ��²����������ļ���
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		//boolean createNewFile();��ָ���ļ�������ʱ�����ļ�������true�����򷵻�false
		File f2 = new File("a.txt");
		System.out.println(f2.createNewFile());
		//boolean mkdir();��ָ���ļ��в�����ʱ�����ļ��в�����true�����򷵻�false
		File f3 = new File("b");
		System.out.println(f3.mkdir());
		//boolean mkdirs();����ָ���ļ��У����ļ������ڵ�Ŀ¼�����ڣ���һ�鴴����,������true�����򷵻�false
		File f4 = new File("c\\d\\e");
		System.out.println(f4.mkdirs());
		
		//boolean delect();
		System.out.println(f2.delete());
		//f4.delect()ɾ������e�ļ���
		System.out.println(f4.delete());
	}
}
