package bull03.DBCP;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import bull01.JDBCbasis.JDBCUtils;

/**
 * DBCP连接池
 * @author 45度炸
 *
 */
public class DBCPdemo1 {
	@Test
	public void demo1() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Properties properties = new Properties();
		try {
			//获得数据源
			properties.load(new FileInputStream("src/dbcp.properties"));
			DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
			//获得连接
			conn = dataSource.getConnection();
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
}
















