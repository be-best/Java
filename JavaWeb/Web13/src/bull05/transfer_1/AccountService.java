package bull05.transfer_1;
/*
 * 业务层进行事务操作
 */
import java.sql.Connection;
import java.sql.SQLException;

import bull05.Utils.C3P0JDBCUtils;
import bull05.Utils.C3P0JDBCUtils_1;

public class AccountService {

	public void transfer(String from, String to, Double money) {
		AccountDao accountDao = new AccountDao();
		try {
			//开启事务
			C3P0JDBCUtils_1.beginTransaction();
			accountDao.outMoney(from,to,money);
			
			//模拟异常
			//int i = 1/0;
			
			accountDao.inMoney(from,to,money);
			//提交事务
			C3P0JDBCUtils_1.commitTransaction();
		} catch (Exception e) {
			try {
				//有异常则回滚
				C3P0JDBCUtils_1.rollbackTransaction();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
	}

}
