package myArrayList;
/*
 * �����ַ����飬������Ԫ�ؼӵ�������
 * ������ŵ���
 * 
 */
import java.util.ArrayList;

public class ArrayListTest2 {
	public static void main(String[] args) {
		String[] arr = {"��һ","����","����","����","����"};
		ArrayList<String> array = new ArrayList<String>();
		for(int x=0;x<arr.length;x++) {
			array.add(arr[x]);
		}
		for(int x=0;x<array.size();x++) {
			String str = array.get(x);
			if(str.startsWith("��")){
				System.out.println(str);
			}
		}
	}
}
