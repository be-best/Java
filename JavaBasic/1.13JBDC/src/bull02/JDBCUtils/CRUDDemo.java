package bull02.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/*
 * ���ݿ���ɾ�Ĳ�
 */
public class CRUDDemo {
	@Test
	public void demo1() {
		//���
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//������ִ����
			st = conn.createStatement();
			//ִ��SQL���
			int r = st.executeUpdate("insert into category (cname) values ('����')");
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		} finally {
			JDBCUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo2() {
		//ɾ��
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//������ִ����
			st = conn.createStatement();
			//ִ��SQL���
			int r = st.executeUpdate("delete from category where cid = 7");
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo3() {
		//�޸�
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//������ִ����
			st = conn.createStatement();
			//ִ��SQL���
			int r = st.executeUpdate("update category set cname = 'ʳƷ' where cid = 3");
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo4() {
		//��ѯ
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//������ִ����
			st = conn.createStatement();
			//ִ��SQL���
			rs = st.executeQuery("select * from category");
			
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid + "---" + cname);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
