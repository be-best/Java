package bull.Landlord;

import java.util.*; 


/*
 * ģ�⶷��������
 */
public class LandlordDemo1 {
	public static void main(String[] args) {
		//��һ����
		String[] color = {"����","����","����","÷��"};
		String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		//��������
		ArrayList<String> array = new ArrayList<String>();
		
		for(int i = 0;i < color.length;i++) {
			for(int j = 0;j < num.length;j++) {
				array.add(color[i]+num[j]);
			}
		}
		array.add("����");
		array.add("С��");
		//System.out.println(array);
		
		//ϴ��
		Collections.shuffle(array);
		//System.out.println(array);
		
		//�������Ѽ���
		ArrayList<String> ���Ŷ��� = new ArrayList<String>();
		ArrayList<String> �¼��¶��� = new ArrayList<String>();
		ArrayList<String> ��˹ά��˹���� = new ArrayList<String>();
		
		//����
		for(int x = 0;x < array.size()-3;x++) {
			if(x%3 == 0) {
				���Ŷ���.add(array.get(x));
			}
			else if(x%3 == 1) {
				�¼��¶���.add(array.get(x));
			}
			else if(x%3 == 2) {
				��˹ά��˹����.add(array.get(x));
			}
		}
		System.out.println("1.���Ŷ���:"+���Ŷ���);
		System.out.println("2.�¼��¶���:"+�¼��¶���);
		System.out.println("3.��˹ά��˹����:"+��˹ά��˹����);
		//����
		System.out.println("*���ƣ�");
		for(int x = array.size()-3;x < array.size();x++) {
			System.out.println(array.get(x));
		}
	}
}
