package ProductDao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Utils.C3P0JDBCUtils;
import domain.Product;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product order by pdate desc";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

}
