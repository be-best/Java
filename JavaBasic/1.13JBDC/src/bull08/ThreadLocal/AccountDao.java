package bull08.ThreadLocal;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import bull.domain.Product;
import bull.utils.JDBCUtils;

/*
 * ���ô���conn����,���ӱ��浽ThreadLocal���ӹ������л�ȡ���ӣ�C3P0Utils.getConnection()��
 */
public class AccountDao {
	public void out(String outUser ,Double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		//sql
		String sql = "update account set money = money + ? where name = ?;";
		//ʵ�ʲ���
		Object[] params = {money,outUser};
		//ִ��
		queryRunner.update(C3P0Utils.getConnection(), sql, params);
	}
	
	public void in(String inUser ,Double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set money = money - ? where name = ?;";
		Object[] params = {money,inUser};
		queryRunner.update(C3P0Utils.getConnection(), sql, params);
	}
	
	
}
