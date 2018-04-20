package bull07.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public void out(Connection conn ,String outUser, Double money) throws SQLException {
		//�������
		//������conn�����Բ����ṩ����Դ��
		QueryRunner queryRunner = new QueryRunner();
		//SQL���
		String sql = "update account set money = money + ? where name = ?;";
		//ʵ�ʲ���
		Object[] param = {money,outUser};
		//ִ��
		queryRunner.update(conn,sql, param);
	}
	
	public void in(Connection conn ,String inUser, Double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set money = money - ? where name = ?;";
		Object[] param = {money,inUser};
		queryRunner.update(conn,sql, param);
	}
}
