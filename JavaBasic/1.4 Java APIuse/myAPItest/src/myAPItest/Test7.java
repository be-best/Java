package myAPItest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test7 {
	public static void main(String[] args) throws IOException {
		// ������������Ч��ȡԴ�ļ�����
		BufferedReader br = new BufferedReader(new FileReader("text.txt"));
		// �������������洢��ȡ�����ַ�������
		ArrayList<String> list = new ArrayList<>();
		String line;
		while((line = br.readLine()) != null){
			String newStr = "";
			//�ַ���ת��Ϊ�ַ����� 
			char[] chs = line.toCharArray();
			for(int x=0;x<chs.length;x++) {
				System.out.println(chs[x]);
			}
			for (int i = chs.length-1; i >= 0; i--) {
				newStr += chs[i];
			}
			
			list.add(newStr);
		}
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt"));
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i));
			bw.newLine();
		}
		bw.close();
	}
}