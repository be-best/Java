package bull02.JDBCconnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;

import bull01.JDBCbasis.JDBCUtils;

/**
 * 
 * @author 45度炸
 * 自定义连接池测试
 */
public class JDBCTest {
	@Test
	public void demo1() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			DataSource dataSource = new MyDataSource();
			conn = dataSource.getConnection();
			String sql = "select * from category";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("cid")+"---"+rs.getString("cname"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
}
