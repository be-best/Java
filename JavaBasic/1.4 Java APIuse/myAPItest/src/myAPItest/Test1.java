package myAPItest;

/*
 * 分析以下需求，并用代码实现
 * 1.键盘录入一个大字符串,再录入一个小字符串
 * 2.统计小字符串在大字符串中出现的次数
 * 3.代码运行打印格式:
 *  请输入大字符串:woaiheima,heimabutongyubaima,wulunheimahaishibaima,zhaodaogongzuojiushihaoma
 *  请输入小字符串:heima
 * 控制台输出:小字符串heima,在大字符串woaiheima,heimabutongyubaima,wulunheimahaishibaima,zhaodaogongzuojiushihaoma中共出现3次
 * 
 * 
 * 1、int indexOf(String str) ：返回第一次出现的指定子字符串在此字符串中的索引。 
 * 2、int indexOf(String str, int startIndex)：从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。 
 * 3、int lastIndexOf(String str) ：返回在此字符串中最右边出现的指定子字符串的索引。 
 * 4、int lastIndexOf(String str, int startIndex) ：从指定的索引处开始向后搜索，返回在此字符串中最后一次出现的指定子字符串的索引。
 */
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//输入第一个字符串
		System.out.println("请输入第一个字符串：");
		String str1 = sc.nextLine();
		//输入第二个字符串
		System.out.println("请输入第二个字符串：");
		String str2 = sc.nextLine();
		
		int count = getCount(str1,str2);
		System.out.println();System.out.println("小字符串" + str2 + ",在大字符串" + str1 + "中共出现" + count + "次");
		
	}
	public static int getCount(String str1,String str2) {
		int index = 0;
		int count = 0;
		//从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。 
		while((index = str1.indexOf(str2, index)) != -1) {
			index = str2.length()+index;//相当于扣去小字符串长度继续下一次查找
			count++;
		}
		return count;
		
	}
}