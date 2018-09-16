package ProductService;

import java.sql.SQLException;
import java.util.List;

import ProductDao.ProductDao;
import domain.Product;

public class ProductService {

	public List<Product> findAll() throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Product> list = productDao.findAll();
		return list;
	}

}
