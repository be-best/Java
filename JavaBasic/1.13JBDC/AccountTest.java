package bull08.ThreadLocal;

public class AccountTest {
	public static void main(String[] args) {
		String outUser = "jack";
		String inUser = "rose";
		Double money = 100.0;
		try {
			AccountService accountService = new AccountService();
			accountService.transfer(outUser, inUser, money);
			//成功的话输出转账成功。
			System.out.println("转账成功！");
		} catch (Exception e) {
			// 出现异常的话则输出转账失败。
			System.out.println("转账失败！");
		}
		
	}
}
