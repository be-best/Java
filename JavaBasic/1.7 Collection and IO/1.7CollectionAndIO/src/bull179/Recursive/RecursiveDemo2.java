package bull179.Recursive;
/*
 * 斐波那契数列
 */
public class RecursiveDemo2 {
	public static void main(String[] args) {
		int sum = getSum(20);
		System.out.println(sum);
	}
	
	public static int getSum(int num) {
		/*
		 * if和 else if的区别
		 * 多个if一起时，每个if都会进行判断：
		 *  if(a) {
		 *  
		 *  }
		 *  if(b) {
		 *  
		 *  }
		 * if和else if一起时，如果有一个符合条件时，则不继续往下判断：
		 * 比如else if(b)成立时，else if(c)不继续执行。
		 *  if(a) {
		 *  
		 *  }
		 *  else if(b) {
		 *  
		 *  }
		 *  else if(c) {
		 *  
		 *  }
		 */
		int sum ;
		if(num == 1) {
			return 1;
		}
		else if(num == 2) {
			return 1;
		}
		else {
			sum = getSum(num-1) + getSum(num-2);
		}
		return sum;
	}
}
