package bull04.Metadata;
/**
 * Ԫ���ݰ���
 * ����ʵ����ɾ��
 */
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import bull04.C3P0.C3P0JDBCUtils;

public class MyDBUtils {
	public static void main(String[] args) {
		//MyDBUtils.update("update category set cname = ? where cid = ?", "��װ",1);
		//MyDBUtils.update("delete from category where cid = ?", 5);
		MyDBUtils.update("insert into category value(?,?)", 4,"���");
		
	}
	
	public static void update(String sql,Object... obj) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = C3P0JDBCUtils.getConnection();
			psmt = conn.prepareStatement(sql);
			ParameterMetaData metaData = psmt.getParameterMetaData();
			for(int i = 1;i <= metaData.getParameterCount();i++) {
				psmt.setObject(i, obj[i-1]);
			}
			int i = psmt.executeUpdate();
			if(i > 0) {
				System.out.println("�����ɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
}
