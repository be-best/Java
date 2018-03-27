package bull1710.File;

import java.io.File;
import java.io.IOException;

/*
 * File的获取和修改功能
 * 获取功能：
 * File getAbsoluteFile()
 * String getAbsolutePath()
 * String getParent()
 * File getParentFile()
 * String getName()
 * String getPath()
 * long lastModified()
 * long length()
 *  修改功能：
 * boolean renameTo(File dest)
 */
public class FileDemo4 {
	public static void main(String[] args) throws IOException {
		//File getAbsoluteFile();返回所创建的File的绝对路径
		File f1 = new File("gAF.txt");
		System.out.println(f1.getAbsoluteFile());
		
		//String getAbsolutePath();返回所创建的File的绝对路径
		File f2 = new File("gAP.txt");
		System.out.println(f2.getAbsolutePath());
		
		//String getParent();返回上层文件    
		File f3 = new File("c\\a");
		System.out.println(f3.getParent());
		
		//File getParentFile();返回上层文件
		File f4 = new File("a\\b\\c");
		f4.mkdirs();
		System.out.println(f4.getParentFile());
		
		//String getName();获取文件和文件夹的名称
		File f5 = new File("gN.txt");
		System.out.println(f5.getName());
		
		//String getPath();返回创建对象时给的路径
		File f6 = new File("gP.txt");
		System.out.println(f6.getPath());
		
		//long lastModified();以毫秒值返回最后修改时间
		File f7 = new File("lM.txt");
		f7.createNewFile();
		System.out.println(f7.lastModified());
		
		//long length();返回文件的字节数，只能是文件。
		File f8 = new File("length.txt");
		f8.createNewFile();
		System.out.println(f8.length());
		
	    //修改功能：boolean renameTo(File dest);将当前File的路径修改为指定File所指向的路径
		//注意f9对象应该生成一个文件，而f10则只要new一个对象不需要生成文件。
		File f9 = new File("rT.txt");
		f9.createNewFile();
		File f10 = new File("rT1.txt");
	
		System.out.println(f9.renameTo(f10));
	}
}
