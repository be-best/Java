package bull02.JDBCUtils;
/*
 * ��SQLע������
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class PrepareDemo {
	@Test
	public void demo1() {
		//���
		Connection conn = null;
		PreparedStatement psmt = null;
	    ResultSet rs = null;
	    
	    try {
			//�������
	    	conn = JDBCUtils.getConnections();
	    	//����SQL���
	    	String sql = "insert into category (cid,cname) values (?,?)";
	    	//���Ԥ�������
	    	psmt = conn.prepareStatement(sql);
	    	//����ʵ�ʲ���
	    	psmt.setInt(1, 4);
	    	psmt.setString(2, "�鱾");
	    	//ִ�У����ص�r�����ݿ�ı������
	    	int r = psmt.executeUpdate();
	    	System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test 
	public void demo2() {
		//ɾ��
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//��ȡsql���
			String sql = "delete from category where cid = ?";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ���
			psmt.setInt(1, 8);
			//ִ��
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo3() {
		//�޸�
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//���SQL���
			String sql = "update category set cname = ? where cid = ?";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ���
			psmt.setString(1, "����");
			psmt.setInt(2, 4);
			//ִ��
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			//�ͷ���Դ
			JDBCUtils.closeResource(conn, psmt, rs);
		}
		
	}
	
	@Test
	public void demo4() {
		//ȫ����ѯ
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//���SQL���
			String sql = "select * from category";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//���ʵ�ʲ���������û�в�����������
			
			//ִ��
			rs = psmt.executeQuery();
			while(rs.next()) {
				Integer cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid + "---" + cname);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo5() {
		//ͨ��id��ѯ
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JDBCUtils.getConnections();
			//���SQL���
			String sql = "select * from category where cid = ?";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ���
			psmt.setInt(1, 1);
			//ִ��
			rs = psmt.executeQuery();
			if(rs.next()) {
				Integer cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid + "---" + cname);
			}
			else {
				System.out.println("��ѯ����");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
}
