package bull1710.File;

import java.io.File;
import java.io.IOException;

/*
 * File�Ļ�ȡ���޸Ĺ���
 * ��ȡ���ܣ�
 * File getAbsoluteFile()
 * String getAbsolutePath()
 * String getParent()
 * File getParentFile()
 * String getName()
 * String getPath()
 * long lastModified()
 * long length()
 *  �޸Ĺ��ܣ�
 * boolean renameTo(File dest)
 */
public class FileDemo4 {
	public static void main(String[] args) throws IOException {
		//File getAbsoluteFile();������������File�ľ���·��
		File f1 = new File("gAF.txt");
		System.out.println(f1.getAbsoluteFile());
		
		//String getAbsolutePath();������������File�ľ���·��
		File f2 = new File("gAP.txt");
		System.out.println(f2.getAbsolutePath());
		
		//String getParent();�����ϲ��ļ�    
		File f3 = new File("c\\a");
		System.out.println(f3.getParent());
		
		//File getParentFile();�����ϲ��ļ�
		File f4 = new File("a\\b\\c");
		f4.mkdirs();
		System.out.println(f4.getParentFile());
		
		//String getName();��ȡ�ļ����ļ��е�����
		File f5 = new File("gN.txt");
		System.out.println(f5.getName());
		
		//String getPath();���ش�������ʱ����·��
		File f6 = new File("gP.txt");
		System.out.println(f6.getPath());
		
		//long lastModified();�Ժ���ֵ��������޸�ʱ��
		File f7 = new File("lM.txt");
		f7.createNewFile();
		System.out.println(f7.lastModified());
		
		//long length();�����ļ����ֽ�����ֻ�����ļ���
		File f8 = new File("length.txt");
		f8.createNewFile();
		System.out.println(f8.length());
		
	    //�޸Ĺ��ܣ�boolean renameTo(File dest);����ǰFile��·���޸�Ϊָ��File��ָ���·��
		//ע��f9����Ӧ������һ���ļ�����f10��ֻҪnewһ��������Ҫ�����ļ���
		File f9 = new File("rT.txt");
		f9.createNewFile();
		File f10 = new File("rT1.txt");
	
		System.out.println(f9.renameTo(f10));
	}
}
