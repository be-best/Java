package bull01.JDBCbasis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
/**
 * 
 * @author 45度炸
 * JDBC测试类 
 */
public class JDBCTest {
	//查询
	@Test
	public void demo1() {
		//获得连接（工具类里会先注册驱动）
		Connection conn = null;
		//conn连接数据库获得语句执行者psmt
		PreparedStatement psmt = null;
		//psmt执行后获得结果集rs
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
	//添加
	@Test
	public void demo2() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs =null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//获得语句执行者
			String sql = "insert into category values (null,?)";
			psmt = conn.prepareStatement(sql);
			//设置参数
			psmt.setString(1, "书包");
			int i = psmt.executeUpdate();
			if(i > 0) {
				System.out.println("添加成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
	
	//修改
	@Test
	public void demo3() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//psmt语句执行者
			String sql = "update category set cname = ? where cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "鞋子");
			psmt.setInt(2, 5);
			int i = psmt.executeUpdate();
			if(i > 0) {
				System.out.println("修改成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
	
	//删除
	@Test
	public void demo4() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//psmt语句执行者
			String sql = "delete from category where cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, 5);
			int i = psmt.executeUpdate();
			if(i > 0) {
				System.out.println("删除成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
}















