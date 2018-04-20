package bull02.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class PreparedDemo {
	@Test
	public void method() {
		String name = "jack #";
		String passwd = "123456";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//��ȡSQL���
			String sql = "select * from user where name = ? and passwd = ?";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ���
			psmt.setString(1, name);
			psmt.setString(2, passwd);
			//ִ��
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("��¼�ɹ���");
			}
			else {
				System.out.println("��¼ʧ�ܣ�");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
}
