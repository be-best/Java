package bull08.ThreadLocal;

public class AccountTest {
	public static void main(String[] args) {
		String outUser = "jack";
		String inUser = "rose";
		Double money = 100.0;
		try {
			AccountService accountService = new AccountService();
			accountService.transfer(outUser, inUser, money);
			//�ɹ��Ļ����ת�˳ɹ���
			System.out.println("ת�˳ɹ���");
		} catch (Exception e) {
			// �����쳣�Ļ������ת��ʧ�ܡ�
			System.out.println("ת��ʧ�ܣ�");
		}
		
	}
}
