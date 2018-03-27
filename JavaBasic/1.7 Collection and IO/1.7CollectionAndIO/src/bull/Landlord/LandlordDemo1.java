package bull.Landlord;

import java.util.*; 


/*
 * 模拟斗地主发牌
 */
public class LandlordDemo1 {
	public static void main(String[] args) {
		//整一副牌
		String[] color = {"黑桃","红桃","方块","梅花"};
		String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		//创建对象
		ArrayList<String> array = new ArrayList<String>();
		
		for(int i = 0;i < color.length;i++) {
			for(int j = 0;j < num.length;j++) {
				array.add(color[i]+num[j]);
			}
		}
		array.add("大王");
		array.add("小王");
		//System.out.println(array);
		
		//洗牌
		Collections.shuffle(array);
		//System.out.println(array);
		
		//创建牌友集合
		ArrayList<String> 澳门赌神 = new ArrayList<String>();
		ArrayList<String> 新加坡赌神 = new ArrayList<String>();
		ArrayList<String> 拉斯维加斯赌神 = new ArrayList<String>();
		
		//发牌
		for(int x = 0;x < array.size()-3;x++) {
			if(x%3 == 0) {
				澳门赌神.add(array.get(x));
			}
			else if(x%3 == 1) {
				新加坡赌神.add(array.get(x));
			}
			else if(x%3 == 2) {
				拉斯维加斯赌神.add(array.get(x));
			}
		}
		System.out.println("1.澳门赌神:"+澳门赌神);
		System.out.println("2.新加坡赌神:"+新加坡赌神);
		System.out.println("3.拉斯维加斯赌神:"+拉斯维加斯赌神);
		//底牌
		System.out.println("*底牌：");
		for(int x = array.size()-3;x < array.size();x++) {
			System.out.println(array.get(x));
		}
	}
}
