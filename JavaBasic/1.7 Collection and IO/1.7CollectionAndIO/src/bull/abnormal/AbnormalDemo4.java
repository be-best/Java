package bull.abnormal;

import java.io.FileWriter;
import java.io.IOException;

/*
 * finally的概述和使用：
 *		释放资源，清除垃圾 		
 */
public class AbnormalDemo4 {
	public static void main(String[] args) {
		//fw要初始化，不然如果fw.write("hello")前有异常的话那么直接跳过try，后面会出现空指针异常。
		FileWriter fw = null;
		try {
			fw = new FileWriter("demo4.txt");
			//System.out.println(2/0);
			fw.write("hello");
			fw.write("hello");
			System.out.println(2/0);
			fw.write("java");
		}catch(IOException i) {
			i.printStackTrace();
		}finally {
			//释放资源，清除垃圾
			try {
				if(fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
