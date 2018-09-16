package bull01.Product.ProductService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import bull.utils.C3P0JDBCUtils;
import bull01.Product.ProductDao.ProductDao;
import bull01.Product.ProductDomain.PageBean;
import bull01.Product.ProductDomain.Product;


public class ProductService {

	/**
	 * ��ѯ��������
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Product> list = productDao.findAll();
		return list;
	}

	/**
	 * �������
	 * @param product
	 * @throws SQLException
	 */
	public void add(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.add(product);
	}

	/**
	 * �޸�����
	 * @param product
	 * @throws SQLException 
	 */
	public void update(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.update(product);
	}

	/**
	 * ����IDѰ�Ҷ�Ӧ��product
	 * @return
	 * @throws SQLException 
	 */
	public Product findById(String id) throws SQLException {
		ProductDao productDao = new ProductDao();
		Product product = productDao.findById(id);
		return product;
	}

	/**
	 * ɾ����������
	 * @param pid
	 * @throws SQLException
	 */
	public void deleteById(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.deleteById(pid);
	}

	/**
	 * ɾ����������,����������ʽ
	 * @param ids
	 */
	public void deleteAll(String[] ids) {
		Connection conn = null;
		try {
			ProductDao productDao = new ProductDao();
			conn = C3P0JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			for (String id : ids) {
				productDao.deleteAll(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��������
	 * @param pname
	 * @return
	 * @throws SQLException
	 */
	public List<Product> search(String pname) throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Product> list = productDao.search(pname);
		return list;
	}

	/**
	 * ��ҳ��ʾ
	 * @param currPage
	 * @return
	 * @throws SQLException 
	 */
	public PageBean pageShow(int currPage) throws SQLException {
		/**
		 * ����PageBean����
		 */
		ProductDao productDao = new ProductDao();
		PageBean pageBean = new PageBean();
		//���õ�ǰҳ��
		pageBean.setCurrPage(currPage);
		//ÿҳ��ʾ��¼��
		int pageSize = 10;
		pageBean.setPageSize(10);
		//�����ܼ�¼��
		int totalCount = productDao.findTotalCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount % pageSize == 0) {
			totalPage = totalCount/pageSize;
		}
		if(totalCount % pageSize != 0) {
			totalPage = totalCount/pageSize + 1;
		}
		/*
		//��totalCountתΪdouble����
		double tC = totalCount;
		//����ȡ��
		Double num = Math.ceil(tC/pageSize);
		//��totalPageתΪint��
		totalPage = num.intValue();
		*/
		pageBean.setTotalPage(totalPage);
		//����ÿҳ�����ݼ���
		int begin = (currPage-1)*pageSize;
		List<Product> list = productDao.findPageProduct(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	

}
