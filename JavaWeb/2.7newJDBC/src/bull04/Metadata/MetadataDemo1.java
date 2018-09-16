package bull04.Metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import bull04.C3P0.C3P0JDBCUtils;



/**
 * Ԫ���ݵ�ʹ��
 * @author 45��ը
 *
 */
public class MetadataDemo1 {
	@Test
	/**
	 * ���ݿ�Ԫ����
	 */
	public void demo1() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		conn = C3P0JDBCUtils.getConnection();
		//������ݿ�Ԫ����
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println("�������ƣ�" + metaData.getDriverName());
			System.out.println("url:" + metaData.getURL());
			System.out.println("�û�����" + metaData.getUserName());
			
			//��ñ��е�����
			rs = metaData.getPrimaryKeys(null, null, "category");
			while(rs.next()) {
				//����
				String keyName = rs.getString("COLUMN_NAME");
				System.out.println(keyName);//��������
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
	
	@Test
	/**
	 * ����Ԫ����
	 */
	public void demo2() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = C3P0JDBCUtils.getConnection();
			String sql = "updata category set cname = ? where cid = ?";
			psmt = conn.prepareStatement(sql);
			//��ȡ��������
			ParameterMetaData meteData = psmt.getParameterMetaData();
			int count = meteData.getParameterCount();
			System.out.println(count);//��������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0JDBCUtils.getConnection();
		}
	}
	
	@Test
	/**
	 * ���Ԫ����
	 */
	public void demo3() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = C3P0JDBCUtils.getConnection();
			String sql = "select * from category";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int count = metaData.getColumnCount();
			for(int i = 1;i <= count;i++) {
				String DBname = metaData.getCatalogName(i);//mydb���ݿ�����
				String name = metaData.getColumnName(i);//��������
				String type = metaData.getColumnTypeName(i);//��������
				System.out.println(DBname+"---"+name+"---"+type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
}

























