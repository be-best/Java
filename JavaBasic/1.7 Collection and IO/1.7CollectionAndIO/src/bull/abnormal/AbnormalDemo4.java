package bull.abnormal;

import java.io.FileWriter;
import java.io.IOException;

/*
 * finally�ĸ�����ʹ�ã�
 *		�ͷ���Դ��������� 		
 */
public class AbnormalDemo4 {
	public static void main(String[] args) {
		//fwҪ��ʼ������Ȼ���fw.write("hello")ǰ���쳣�Ļ���ôֱ������try���������ֿ�ָ���쳣��
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
			//�ͷ���Դ���������
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
