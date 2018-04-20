package bull07.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import bull03.C3P0.C3P0Utils;
import bull07.dao.AccountDao;

public class AccountService {
	public void transfer(String outUser,String inUser,Double money) {	
		Connection conn = null;
		try {
			//�������
			conn = C3P0Utils.getConnection();
			//��������
			conn.setAutoCommit(false);
			//ҵ�����
			AccountDao accountDao = new AccountDao();
			accountDao.out(conn,outUser,money);
			//ģ���쳣
			//int i = 1/0;
			accountDao.in(conn,inUser, money);
			
			//�ύ�����ͷ���Դ
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			// ����ع�
			DbUtils.rollbackAndCloseQuietly(conn);
			throw new RuntimeException(e);
		}
	}
}
