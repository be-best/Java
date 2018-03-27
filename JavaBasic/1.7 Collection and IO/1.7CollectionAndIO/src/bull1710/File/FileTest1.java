package bull1710.File;

import java.io.File;

/*
 * 需求：输出指定目录下的所有java文件名（包含子目录）
 */
public class FileTest1 {
	public static void main(String[] args) {
		File f = new File("src\\bull1710\\File");
		method(f);
	}
	
	public static void method(File f) {
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				if(file.getName().endsWith(".java")) {
					System.out.println(file.getName());
				}
				//如果file不是文件而是文件夹则继续递归；
				if(file.isDirectory()) {
					method(file);
				}
			}
		}
	}
}
