package bull.abnormal;

import javax.management.RuntimeErrorException;

/*
 * 异常案例：验证分数，大于100或者小于0则属于异常
 * 	throw:处理异常的一种方式，把异常抛出，由调用者来处理
 * 	throws:制造异常的方式，并且结束方法
 * 
 * 注意：如果抛出(throw)的是编译时期异常，必须在方法声明处抛出(throws)
 * 
 * 如何自定义一个异常类？
 * 		写一个类去继承RuntimeException或者Exception,然后实现多个构造。
 */
public class AbnormalDemo6 {
	public static void main(String[] args) {
		
		try {
			checkScore(1001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void checkScore(int score){
		if(score < 0||score >100) {
			//throw new RuntimeException("run分数错误");
			//throw new Exception("exc分数错误");
			throw new MyException("my分数错误");
		}
		
		System.out.println("考试成绩符合要求");
	}
}
