package bull07.test;

import java.sql.SQLException;

import bull07.service.AccountService;

public class AccountTest {
	public static void main(String[] args) {
		String outUser = "rose";
		String inUser = "jack";
		Double money = 200.0;
		try {
			AccountService accountService = new AccountService();
			accountService.transfer(outUser, inUser, money);
			System.out.println("ת�˳ɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ת��ʧ�ܣ�");
		}
	}
}
