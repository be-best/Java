package bull1710.File;

import java.io.File;

/*
 * File
 */
public class FileDemo1 {
	public static void main(String[] args) {
		//File(String pathname):将指定的路径名转为File对象
		File f1 = new File("F:\\a\\b.txt");
		//File(String parent,String child)；根据指定的父路径和文件路径创建File对象
		File f2 = new File("F:\\a","c.txt");
		//File(File parent,String child)；根据指定的父路径对象和文件路径创建File对象
		File parent = new File("F:\\a");
		File f3 = new File(parent,"d.txt");
		//采用匿名对象方式
		File f4 = new File(new File("F:\\a"),"e.txt");
	}
}
