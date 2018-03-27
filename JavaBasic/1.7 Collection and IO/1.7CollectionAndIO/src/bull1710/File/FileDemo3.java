package bull1710.File;

import java.io.File;
import java.io.IOException;

/*
 * File的判断功能
 */
public class FileDemo3 {
	public static void main(String[] args) throws IOException {
		//boolean exists();判断文件是否存在，存在返回true,否则false
		File f1 = new File("Fdemo3.txt");
		f1.createNewFile();
		System.out.println(f1.exists());
		
		//boolean isAbsolute();判断File对象（注意是对象）指向的路径是否是绝对路径，如果是返回true,否则false
		File f2 = new File("f:\\a\\b.txt");
		System.out.println(f2.isAbsolute());
		
		//boolean isDirectory();判断是否是文件夹
		File f3 = new File("a");
		f3.mkdir();
		System.out.println(f3.isDirectory());
		
		//boolean idFile();判断是否是文件
		File f4 = new File("b.txt");
		f4.createNewFile();
		System.out.println(f4.isFile());
		
		//booelan isHidden();判断File指向的路径是否有隐藏属性，如果有则返回true，否则返回false	
		File f5 = new File("f:\\a\\c");
		f5.mkdirs();
		System.out.println(f5.isHidden());
	}
}
