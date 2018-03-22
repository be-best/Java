package myInteger;
/*
 * 自动装箱与自动拆箱
 */
public class IntegerDemo2 {
	public static void main(String[] args) {
		//自动装箱
		//相当于Integer i = new Integer(10);
		Integer i = 10;
		
		//自动拆箱
		Integer i1 = 10;//自动装箱
		int a = i1; //相当于 int a = i1.intValue();
		
		Integer i2 = 10;
		Integer i3 = 11;
		Integer i4 = i2 + i3;
		//相当于Integer i4 = new Integer(i2.intValue() + i3.intValue());
	}
}
