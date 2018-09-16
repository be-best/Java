package bull02.Ajax.AjaxDao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bull.utils.C3P0JDBCUtils;
import bull02.Ajax.domain.Content;
import bull02.Ajax.domain.User;

public class Test {
	public static void main(String[] args) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from user2";
		String sql1 = "select * from words";
		List<User> list1 = queryRunner.query(sql, new BeanListHandler<User>(User.class));
		List<Content> list2 = queryRunner.query(sql1, new BeanListHandler<Content>(Content.class));
		for (User content2 : list1) {
			System.out.println(content2.getId()+content2.getUsername());
		}
		for (Content content2 : list2) {
			System.out.println(content2.getId()+content2.getContent());
		}
	}
}
