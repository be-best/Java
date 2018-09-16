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
 * 元数据的使用
 * @author 45度炸
 *
 */
public class MetadataDemo1 {
	@Test
	/**
	 * 数据库元数据
	 */
	public void demo1() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		conn = C3P0JDBCUtils.getConnection();
		//获得数据库元数据
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println("驱动名称：" + metaData.getDriverName());
			System.out.println("url:" + metaData.getURL());
			System.out.println("用户名：" + metaData.getUserName());
			
			//获得表中的主键
			rs = metaData.getPrimaryKeys(null, null, "category");
			while(rs.next()) {
				//主键
				String keyName = rs.getString("COLUMN_NAME");
				System.out.println(keyName);//主键名称
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
	
	@Test
	/**
	 * 参数元数据
	 */
	public void demo2() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = C3P0JDBCUtils.getConnection();
			String sql = "updata category set cname = ? where cid = ?";
			psmt = conn.prepareStatement(sql);
			//获取参数个数
			ParameterMetaData meteData = psmt.getParameterMetaData();
			int count = meteData.getParameterCount();
			System.out.println(count);//参数个数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0JDBCUtils.getConnection();
		}
	}
	
	@Test
	/**
	 * 结果元数据
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
				String DBname = metaData.getCatalogName(i);//mydb数据库名称
				String name = metaData.getColumnName(i);//属性名称
				String type = metaData.getColumnTypeName(i);//数据类型
				System.out.println(DBname+"---"+name+"---"+type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
}

























