package bull01.JDBCbasis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
/**
 * 
 * @author 45��ը
 * JDBC�����ݿ���ɾ�Ĳ�
 */
public class JDBCTest2 {
	@Test
	public void demo() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs =null;
		
		try {
			//�������
			conn = JDBCUtils.getConnection();
			//������ִ����
			String sql = "insert into category values (null,?)";
			psmt = conn.prepareStatement(sql);
			//���ò���
			psmt.setString(1, "���");
			int i = psmt.executeUpdate();
			if(i > 0) {
				System.out.println("��ӳɹ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
}
