package bull08.ThreadLocal;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;

public class AccountService {
	public void transfer(String outUser ,String inUser ,Double money) {
		Connection conn = null;
		try {
			//�������
			conn = C3P0Utils.getConnection();
			//��������
			conn.setAutoCommit(false);
			//ҵ�����
			AccountDao accountDao = new AccountDao();
			accountDao.out(outUser, money);
			accountDao.in(inUser, money);
			//�ύ����
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			// ����ع�
			DbUtils.rollbackAndCloseQuietly(conn);
			throw new RuntimeException(e);
		}
	}
}
