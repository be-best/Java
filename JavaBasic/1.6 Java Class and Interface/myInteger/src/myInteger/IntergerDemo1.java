package myInteger;
/*
 * Integer:
 * 		String --- int
 * 			方式一：int intValue()
 * 			方式二：static int parseInt(String s)
 * 		int --- String
 * 			方式一：+""
 * 			方式二：String toString()
*/
public class IntergerDemo1 {
	public static void main(String[] args) {
		//int intValue()
		Integer intg = new Integer("10");
		int a1 = intg.intValue();
		System.out.println(a1+20);
		//static int parseInt(String s)
		int a = Integer.parseInt("30");
		System.out.println(a+20);
		
		//String toString()
		Integer intg1 = new Integer(30);
		String str = intg1.toString();
		System.out.println(str);
		
		//static String toString(int i)
		String str1 = Integer.toString(50);
		System.out.println(str1);
		
	}
}
