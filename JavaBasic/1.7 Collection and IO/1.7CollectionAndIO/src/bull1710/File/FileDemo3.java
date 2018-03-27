package bull1710.File;

import java.io.File;
import java.io.IOException;

/*
 * File���жϹ���
 */
public class FileDemo3 {
	public static void main(String[] args) throws IOException {
		//boolean exists();�ж��ļ��Ƿ���ڣ����ڷ���true,����false
		File f1 = new File("Fdemo3.txt");
		f1.createNewFile();
		System.out.println(f1.exists());
		
		//boolean isAbsolute();�ж�File����ע���Ƕ���ָ���·���Ƿ��Ǿ���·��������Ƿ���true,����false
		File f2 = new File("f:\\a\\b.txt");
		System.out.println(f2.isAbsolute());
		
		//boolean isDirectory();�ж��Ƿ����ļ���
		File f3 = new File("a");
		f3.mkdir();
		System.out.println(f3.isDirectory());
		
		//boolean idFile();�ж��Ƿ����ļ�
		File f4 = new File("b.txt");
		f4.createNewFile();
		System.out.println(f4.isFile());
		
		//booelan isHidden();�ж�Fileָ���·���Ƿ����������ԣ�������򷵻�true�����򷵻�false	
		File f5 = new File("f:\\a\\c");
		f5.mkdirs();
		System.out.println(f5.isHidden());
	}
}
