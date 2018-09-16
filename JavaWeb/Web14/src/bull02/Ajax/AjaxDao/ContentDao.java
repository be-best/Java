package bull02.Ajax.AjaxDao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bull.utils.C3P0JDBCUtils;
import bull02.Ajax.domain.Content;

public class ContentDao {

	public List<Content> findContent(String content) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from user2";
		List<Content> list = queryRunner.query(sql, new BeanListHandler<Content>(Content.class));
		for (Content content2 : list) {
			System.out.println(content2.getId()+content2.getContent());
		}
		return list;
	}
}
