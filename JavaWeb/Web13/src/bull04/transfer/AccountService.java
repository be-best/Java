package bull04.transfer;
/*
 * ҵ�������������
 */
import java.sql.Connection;
import java.sql.SQLException;

import bull05.Utils.C3P0JDBCUtils;

public class AccountService {

	public void transfer(String from, String to, Double money) {
		AccountDao accountDao = new AccountDao();
		Connection conn = null;
		try {
			conn = C3P0JDBCUtils.getConnection();
			//��������
			conn.setAutoCommit(false);
			accountDao.outMoney(conn,from,to,money);
			
			//ģ���쳣
			//int i = 1/0;
			
			accountDao.inMoney(conn,from,to,money);
			//�ύ����
			conn.commit();
		} catch (Exception e) {
			try {
				//���쳣��ع�
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				//�ر�conn����
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
