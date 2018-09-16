package bull01.JDBCbasis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
/**
 * 
 * @author 45��ը
 * JDBC������ 
 */
public class JDBCTest {
	//��ѯ
	@Test
	public void demo1() {
		//������ӣ������������ע��������
		Connection conn = null;
		//conn�������ݿ������ִ����psmt
		PreparedStatement psmt = null;
		//psmtִ�к��ý����rs
		ResultSet rs =null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from category";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("cid")+"---"+rs.getString("cname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
	//���
	@Test
	public void demo2() {
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
				System.out.println("��ӳɹ�!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
	
	//�޸�
	@Test
	public void demo3() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//�������
			conn = JDBCUtils.getConnection();
			//psmt���ִ����
			String sql = "update category set cname = ? where cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "Ь��");
			psmt.setInt(2, 5);
			int i = psmt.executeUpdate();
			if(i > 0) {
				System.out.println("�޸ĳɹ�!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
	
	//ɾ��
	@Test
	public void demo4() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//�������
			conn = JDBCUtils.getConnection();
			//psmt���ִ����
			String sql = "delete from category where cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, 5);
			int i = psmt.executeUpdate();
			if(i > 0) {
				System.out.println("ɾ���ɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
}















