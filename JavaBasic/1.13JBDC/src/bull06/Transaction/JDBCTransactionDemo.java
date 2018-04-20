package bull06.Transaction;
/*
 * JDBC�������
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import bull03.C3P0.C3P0Utils;

public class JDBCTransactionDemo {
	@Test
	public void demo() throws SQLException {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			//�������
			conn = C3P0Utils.getConnection();
			//��������
			conn.setAutoCommit(false);
			//����
			String sql = "update account set money = money + ? where name = ?";
			psmt = conn.prepareStatement(sql);
			//��Ǯ
			psmt.setInt(1, -100);
			psmt.setString(2, "jack");
			psmt.executeUpdate();
			
			//ģ���쳣
			//int i = 1/0;//��ʱ��������ع�����Ϊ��Ǯ��ǮҪ���ɹ��Ų�����ֻع���
			
			//��Ǯ
			psmt.setInt(1, 100);
			psmt.setString(2, "rose");
			psmt.executeUpdate();
			
			//�ύ����
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw new RuntimeException("����ع�",e);
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
}
