package bull179.Recursive;
/*
 * 쳲���������
 */
public class RecursiveDemo2 {
	public static void main(String[] args) {
		int sum = getSum(20);
		System.out.println(sum);
	}
	
	public static int getSum(int num) {
		/*
		 * if�� else if������
		 * ���ifһ��ʱ��ÿ��if��������жϣ�
		 *  if(a) {
		 *  
		 *  }
		 *  if(b) {
		 *  
		 *  }
		 * if��else ifһ��ʱ�������һ����������ʱ���򲻼��������жϣ�
		 * ����else if(b)����ʱ��else if(c)������ִ�С�
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
