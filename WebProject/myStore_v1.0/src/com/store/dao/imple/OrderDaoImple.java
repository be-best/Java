package com.store.dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.store.dao.OrderDao;
import com.store.domain.OrderItem;
import com.store.domain.Orders;
import com.store.domain.Product;
import com.store.utils.C3P0JDBCUtils;

public class OrderDaoImple implements OrderDao {

	/**
	 * ���ɱ��涩��
	 * @throws SQLException 
	 */
	@Override
	public void creatOrder(Connection conn, Orders orders) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into orders values (?,?,?,?,?,?,?,?)";
		//��ס���ݿ���ȥ��������ֵ����ʵ���в����������ʽ��User����Uid����߼ǵô���getUser().getUid();
		Object[] params = {orders.getOid(),orders.getOrderTime(),orders.getTotal(),orders.getState(),
				orders.getAddress(),orders.getTelephone(),orders.getName(),orders.getUser().getUid()};
		queryRunner.update(conn, sql, params);
	}

	/**
	 * ���涩���е�һ����������
	 * @throws SQLException 
	 */
	@Override
	public void creatOrderItem(Connection conn, OrderItem orderItem) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into orderItem values (?,?,?,?,?)";
		//��ס���ݿ���ȥ��������ֵ����ʵ���в����������ʽ��Product��Orders����Pid,Oid����߼ǵô���getProduct().getPid(),getOrder.getOid();
		Object[] params = {orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),
				orderItem.getProduct().getPid(),orderItem.getOrders().getOid()};
		queryRunner.update(conn, sql, params);
	}

	/**
	 * ��ѯuid����û��Ķ����ܸ���
	 * @throws SQLException 
	 */
	@Override
	public Integer findCountByUid(String uid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from orders where uid = ?";
		Long count = (Long) queryRunner.query(sql, new ScalarHandler(), uid);
		return count.intValue();
	}

	/**
	 * ��ѯuid�û������ж�������
	 * ֻ����orders��ᷢ��orders�������û��orderItem
	 * ��domain��ordersʵ��������ҪorderItem��
	 * ��Ҫʹ�ö���ѯ
	 * @throws SQLException 
	 */
	@Override
	public List<Orders> findOrderByUid(String uid,int begin,int pageSize) throws Exception {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from orders where uid = ? order by ordertime desc limit ?,?";
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class) ,uid,begin,pageSize);
		for (Orders orders : list) {
			//����ѯ���Զ�����ź���ƷIDΪ������ѯproduct��orderitem�еĸ�������
			sql = "select * from product p ,orderitem o where p.pid = o.pid and o.oid=?";
			//MapListHandler:�Ѵ�product��orderitem�в�ѯ�ĸ������ԺͶ�Ӧֵ��װ��һ��map,Ȼ����Щmap�ٷ�װ��һ��list�С�
			List<Map<String,Object>> olist =  queryRunner.query(sql, new MapListHandler(), orders.getOid());
			//������ҪΪ��ѯ���Ķ���list���orderitem,����olist��map����
			for (Map<String, Object> map : olist) {
				//��װһ��product
				Product product = new Product();
				BeanUtils.populate(product, map);
				//product.setPdate(new Date());
				//��װorderitem
				OrderItem orderItem = new OrderItem();
				BeanUtils.populate(orderItem, map);
				
				//��ΪorderItem����product
				orderItem.setProduct(product);
				
				//��ȡ�����Ķ�����orderitem���ϣ�������µĶ�����
				orders.getOrderItems().add(orderItem);
			}
		}
		//��������Ӻö�����orderitem,��װ���
		return list;
	}

	/**
	 * ɾ������
	 * @throws SQLException 
	 */
	@Override
	public void deleteOrderByOid(String oid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "delete from orders where oid = ?";
		String sql2 = "delete from orderitem where oid = ?";
		queryRunner.update(sql2,oid);
		queryRunner.update(sql,oid);
	}

	/**
	 * ��ѯ��������
	 * @throws Exception 
	 */
	@Override
	public Orders findOrderByOid(String oid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		//�Ȳ�ѯ����
		String sql = "select * from orders where oid = ?";
		Orders order = queryRunner.query(sql, new BeanHandler<Orders>(Orders.class) ,oid);
		//��������û�ж�����������ݣ����Ե��ٲ�ѯ������
		sql = "select * from product p,orderitem o where p.pid = o.pid and o.oid = ?";
		List<Map<String,Object>> list = queryRunner.query(sql, new MapListHandler(), order.getOid());
		for (Map<String, Object> map : list) {
			//��װproduct
			Product product = new Product();
			BeanUtils.populate(product, map);
			//��װ����
			OrderItem orderItem = new OrderItem();
			BeanUtils.populate(orderItem, map);
			//����Ʒproduct��ӵ�orderItem
			orderItem.setProduct(product);
			//��ȡ�����Ķ�����ϣ�������µ�orderItem  
			order.getOrderItems().add(orderItem);
		}
		return order;
	}

	/**
	 * ���¶�����Ϣ
	 * @throws SQLException 
	 */
	@Override
	public void updateOrder(Orders order) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "update orders set total=?, state=? ,address=?, name=?, telephone=? where oid = ?";
		queryRunner.update(sql, order.getTotal(),order.getState(),order.getAddress(),
				order.getName(),order.getTelephone(),order.getOid());
	}

	/**
	 * ��ѯ���еĶ�������
	 * @throws SQLException 
	 */
	@Override
	public Integer findAllCount() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from orders order by ordertime desc";
		Long count = (Long) queryRunner.query(sql, new ScalarHandler());
		return count.intValue();
	}

	/**
	 * ��̨��ҳ��ѯ���ж���
	 * @throws SQLException 
	 */
	@Override
	public List<Orders> findAllOrder(int begin, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from orders order by ordertime desc limit ?,?";
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class), begin,pageSize);
		return list;
	}

	/**
	 * ��״̬��ѯ��������
	 * @throws SQLException 
	 */
	@Override
	public Integer findCountByState(Integer state) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from orders where state = ? order by ordertime desc";
		Long count = (Long) queryRunner.query(sql, new ScalarHandler(),state);
		return count.intValue();
	}

	/**
	 * ��״̬��ѯ����
	 */
	@Override
	public List<Orders> findOrderByState(Integer state, int begin, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from orders where state = ? order by ordertime desc limit ?,?";
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class), state,begin,pageSize);
		return list;
	}

	/**
	 * ��̨��ѯ��������,���ض������
	 * @throws SQLException 
	 */
	@Override
	public List<OrderItem> showDetail(String oid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from orders where oid = ?";
		Orders order = queryRunner.query(sql, new BeanHandler<Orders>(Orders.class), oid);
		//���Ҷ����product.pid = orderitem.oid&orderitem.oid = order.oid;
		sql = "select * from product p,orderitem o where p.pid=o.pid and o.oid = ?";
		List<Map<String,Object>> list = queryRunner.query(sql, new MapListHandler(), order.getOid());
		List<OrderItem> olist = new ArrayList<OrderItem>();
		for (Map<String, Object> map : list) {
			OrderItem orderItem = new OrderItem();
			Product product = new Product();
			BeanUtils.populate(product, map);
			BeanUtils.populate(orderItem, map);
			
			orderItem.setProduct(product);
			olist.add(orderItem);
			
		}
		return olist;
	}

	/**
	 * ģ����ѯ��������
	 * @throws SQLException 
	 */
	@Override
	public Integer findCountByOidKeywords(String oidKeywords) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		if(oidKeywords.length() < 30) {
			if(oidKeywords.length() == 11) {
				String sql1 = "select count(*) from orders where telephone = ?";
				Long countTel = (Long) queryRunner.query(sql1, new ScalarHandler(), oidKeywords);
				return countTel.intValue();
			} else {
				String sql2 = "select count(*) from orders where name like ?";
				Long countNam = (Long) queryRunner.query(sql2, new ScalarHandler(),"%"+oidKeywords+"%");
				return countNam.intValue();
			}
		}
		String sql3 = "select count(*) from orders where oid = ?";
		Long countOid = (Long) queryRunner.query(sql3, new ScalarHandler(), oidKeywords);
		return countOid.intValue();
	}

	/**
	 * ģ����ѯ����
	 * @throws SQLException 
	 */
	@Override
	public List<Orders> findOrderByOidKeywords(String oidKeywords, int begin,int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		System.out.println(oidKeywords.length());
		if(oidKeywords.length() < 30) {
			if(oidKeywords.length() == 11) {
				String sql1 = "select * from orders where telephone = ? order by ordertime desc limit ?,?";
				List<Orders> list1 = queryRunner.query(sql1, new BeanListHandler<Orders>(Orders.class), oidKeywords,begin,pageSize);
				return list1;
			} else {
				String sql2 = "select * from orders where name like ? order by ordertime desc limit ?,?";
				List<Orders> list2 = queryRunner.query(sql2, new BeanListHandler<Orders>(Orders.class), "%"+oidKeywords+"%",begin,pageSize);
				return list2;
			}
		}
		String sql = "select * from orders where oid = ? order by ordertime desc limit ?,?";
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class), oidKeywords,begin,pageSize);
		return list;
	}

	

}











