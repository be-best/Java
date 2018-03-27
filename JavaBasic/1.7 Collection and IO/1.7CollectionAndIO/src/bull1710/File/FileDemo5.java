package bull1710.File;

import java.io.File;
import java.io.IOException;

public class FileDemo5 {
	public static void main(String[] args) throws IOException {
		File f1 = new File("length.txt");
		File f2 = new File("f2.txt");
		f1.createNewFile();
		
		System.out.println(f1.renameTo(f2));
	}
}
