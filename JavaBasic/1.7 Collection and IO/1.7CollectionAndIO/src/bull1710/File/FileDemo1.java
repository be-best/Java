package bull1710.File;

import java.io.File;

/*
 * File
 */
public class FileDemo1 {
	public static void main(String[] args) {
		//File(String pathname):��ָ����·����תΪFile����
		File f1 = new File("F:\\a\\b.txt");
		//File(String parent,String child)������ָ���ĸ�·�����ļ�·������File����
		File f2 = new File("F:\\a","c.txt");
		//File(File parent,String child)������ָ���ĸ�·��������ļ�·������File����
		File parent = new File("F:\\a");
		File f3 = new File(parent,"d.txt");
		//������������ʽ
		File f4 = new File(new File("F:\\a"),"e.txt");
	}
}
