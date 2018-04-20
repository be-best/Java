package bull.ProductService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import bull.ProductDao.ProductDao;
import bull.domain.Product;
import bull.utils.JDBCUtils;

/*
 * 
 */
public class ProductService {
	private static final int Integer = 0;
	private static final int List = 0;
	private ProductDao productDao = new ProductDao();
	
	

	public void add(Product product) throws SQLException {
		//���
		productDao.add(product);
	}

	
	public Product findById(Integer pid) throws SQLException {
		// ��ѯ
		return productDao.findById(pid);
	}
	


	public void edit(Product product) throws SQLException {
		// �޸�
		productDao.edit(product);
		
	}


	public List findAll() throws SQLException {
		// ��ѯ����
		return productDao.findAll();
		
	}


	public void delete(Integer pid) {
		// ɾ��,�������������ʽ
		Connection conn = null;
		try {
			//�������
			conn = JDBCUtils.getConnection();
			//��������
			conn.setAutoCommit(false);
			//�������
			productDao.delete(pid);
			//�ύ����
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			// ����ع�
			DbUtils.rollbackAndCloseQuietly(conn);
			throw new RuntimeException(e);
		}
		
	}


	public void deleteAll(List<Integer> list) {
		// ����ɾ����¼���������������ʽ
		Connection conn = null;
		try {
			//�������
			conn = JDBCUtils.getConnection();
			//��������
			conn.setAutoCommit(false);
			//�������
			//���ѭ��ɾ����¼
			for (Integer pid : list) {
				productDao.deleteAll(pid);
			}
			//�ύ����
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			// ����ع�
			DbUtils.rollbackAndCloseQuietly(conn);
			throw new RuntimeException(e);
		}
		
	}
}










