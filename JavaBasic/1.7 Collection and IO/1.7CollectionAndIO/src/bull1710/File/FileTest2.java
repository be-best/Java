package bull1710.File;

import java.io.File;

/*
 * 需求：删除指定目录下的文件。
 *   需要先删除子目录下的文件
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
				//删除文件
				if(file.isFile()) {
					System.out.println(file.getName());
					file.delete();
				}
				//如果是文件夹则要继续先删除子文件
				else if(file.isDirectory()) {
					method(file);
				}
			}
			//删除自己
			System.out.println(f.getName());
			f.delete();
		}
	}
}
