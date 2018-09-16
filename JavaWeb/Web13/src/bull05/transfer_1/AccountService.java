package bull05.transfer_1;
/*
 * ҵ�������������
 */
import java.sql.Connection;
import java.sql.SQLException;

import bull05.Utils.C3P0JDBCUtils;
import bull05.Utils.C3P0JDBCUtils_1;

public class AccountService {

	public void transfer(String from, String to, Double money) {
		AccountDao accountDao = new AccountDao();
		try {
			//��������
			C3P0JDBCUtils_1.beginTransaction();
			accountDao.outMoney(from,to,money);
			
			//ģ���쳣
			//int i = 1/0;
			
			accountDao.inMoney(from,to,money);
			//�ύ����
			C3P0JDBCUtils_1.commitTransaction();
		} catch (Exception e) {
			try {
				//���쳣��ع�
				C3P0JDBCUtils_1.rollbackTransaction();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
	}

}
