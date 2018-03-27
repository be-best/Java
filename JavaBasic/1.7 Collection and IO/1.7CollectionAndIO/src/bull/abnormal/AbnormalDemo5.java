package bull.abnormal;

import java.io.FileWriter;

/*
 * 异常的分类：
 * 		运行时期异常：RuntimeException的子类就是运行时期异常，在编译时期可以选择处理或者不出理。
 * 		编译时期异常：Exception的子类，非RuntimeException的子类，在编译时期必须处理。
 */
public class AbnormalDemo5 {
	public static void main(String[] args) {
		//运行时期异常
		//空指针异常
		String str = null;
		System.out.println(str.length());
		
		//编译时期异常，比如IO流要处理的异常
		try {
			FileWriter fw = new FileWriter("demo5.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
