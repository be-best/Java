package bull06.Transaction;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import bull03.C3P0.C3P0Utils;

/*
 * DBUtils�������
 */
public class DBUtilsTransaction {
	@Test
	public void demo() {
		Connection conn = null;
		//���ø�����Դ��conn������ӡ�
		//QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		QueryRunner queryRunner = new QueryRunner();
		try {
			//�������
			conn = C3P0Utils.getConnection();
			//��������
			conn.setAutoCommit(false);
			//����
			String sql = "update account set money = money + ? where name = ?;";
			int i = queryRunner.update(conn, sql, 100,"jack");
			int j = queryRunner.update(conn, sql, -100,"rose");
			//�ύ�����ͷ���Դ
			DbUtils.commitAndCloseQuietly(conn);
			System.out.println("�ύ�ɹ���");
		} catch (Exception e) {
			e.printStackTrace();//��������쳣��
			//����ع�
			DbUtils.rollbackAndCloseQuietly(conn);
		}
	}
}
