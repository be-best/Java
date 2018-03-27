package bull1710.File;

import java.io.File;
import java.io.IOException;

/*
 * File创建和删除
 * 
 * 创建功能：
 * 		boolean createNewFile();
 * 		boolean mkdir();
 * 		boolean mkdirs();
 * 
 * 删除功能：
 * 		boolean delect();
 * 		注意：删除一个文件 时，这个文件下不能有其他文件夹
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		//boolean createNewFile();当指定文件不存在时创建文件并返回true，否则返回false
		File f2 = new File("a.txt");
		System.out.println(f2.createNewFile());
		//boolean mkdir();当指定文件夹不存在时创建文件夹并返回true，否则返回false
		File f3 = new File("b");
		System.out.println(f3.mkdir());
		//boolean mkdirs();创建指定文件夹，当文件夹所在的目录不存在，则一块创建了,并返回true，否则返回false
		File f4 = new File("c\\d\\e");
		System.out.println(f4.mkdirs());
		
		//boolean delect();
		System.out.println(f2.delete());
		//f4.delect()删除的是e文件夹
		System.out.println(f4.delete());
	}
}
