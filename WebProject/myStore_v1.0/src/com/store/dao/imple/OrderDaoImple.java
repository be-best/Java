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
	 * 生成保存订单
	 * @throws SQLException 
	 */
	@Override
	public void creatOrder(Connection conn, Orders orders) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into orders values (?,?,?,?,?,?,?,?)";
		//记住数据库存进去的是属性值，像实体中采用面向对象方式用User代替Uid，这边记得存入getUser().getUid();
		Object[] params = {orders.getOid(),orders.getOrderTime(),orders.getTotal(),orders.getState(),
				orders.getAddress(),orders.getTelephone(),orders.getName(),orders.getUser().getUid()};
		queryRunner.update(conn, sql, params);
	}

	/**
	 * 保存订单中的一个个订单项
	 * @throws SQLException 
	 */
	@Override
	public void creatOrderItem(Connection conn, OrderItem orderItem) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into orderItem values (?,?,?,?,?)";
		//记住数据库存进去的是属性值，像实体中采用面向对象方式用Product、Orders代替Pid,Oid，这边记得存入getProduct().getPid(),getOrder.getOid();
		Object[] params = {orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),
				orderItem.getProduct().getPid(),orderItem.getOrders().getOid()};
		queryRunner.update(conn, sql, params);
	}

	/**
	 * 查询uid这个用户的订单总个数
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
	 * 查询uid用户的所有订单集合
	 * 只查找orders你会发现orders这个表里没有orderItem
	 * 而domain的orders实体里是需要orderItem的
	 * 需要使用多表查询
	 * @throws SQLException 
	 */
	@Override
	public List<Orders> findOrderByUid(String uid,int begin,int pageSize) throws Exception {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from orders where uid = ? order by ordertime desc limit ?,?";
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class) ,uid,begin,pageSize);
		for (Orders orders : list) {
			//多表查询，以订单编号和商品ID为条件查询product和orderitem中的各个属性
			sql = "select * from product p ,orderitem o where p.pid = o.pid and o.oid=?";
			//MapListHandler:把从product和orderitem中查询的各个属性和对应值封装进一个map,然后这些map再封装到一个list中。
			List<Map<String,Object>> olist =  queryRunner.query(sql, new MapListHandler(), orders.getOid());
			//现在需要为查询到的订单list添加orderitem,遍历olist的map集合
			for (Map<String, Object> map : olist) {
				//封装一个product
				Product product = new Product();
				BeanUtils.populate(product, map);
				//product.setPdate(new Date());
				//封装orderitem
				OrderItem orderItem = new OrderItem();
				BeanUtils.populate(orderItem, map);
				
				//再为orderItem设置product
				orderItem.setProduct(product);
				
				//获取订单的订单项orderitem集合，并添加新的订单项
				orders.getOrderItems().add(orderItem);
			}
		}
		//订单中添加好订单项orderitem,封装完毕
		return list;
	}

	/**
	 * 删除订单
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
	 * 查询单个订单
	 * @throws Exception 
	 */
	@Override
	public Orders findOrderByOid(String oid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		//先查询订单
		String sql = "select * from orders where oid = ?";
		Orders order = queryRunner.query(sql, new BeanHandler<Orders>(Orders.class) ,oid);
		//订单表中没有订单项这个内容，所以得再查询订单项
		sql = "select * from product p,orderitem o where p.pid = o.pid and o.oid = ?";
		List<Map<String,Object>> list = queryRunner.query(sql, new MapListHandler(), order.getOid());
		for (Map<String, Object> map : list) {
			//封装product
			Product product = new Product();
			BeanUtils.populate(product, map);
			//封装订单
			OrderItem orderItem = new OrderItem();
			BeanUtils.populate(orderItem, map);
			//将商品product添加到orderItem
			orderItem.setProduct(product);
			//获取订单的订单项集合，并添加新的orderItem  
			order.getOrderItems().add(orderItem);
		}
		return order;
	}

	/**
	 * 更新订单信息
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
	 * 查询所有的订单个数
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
	 * 后台分页查询所有订单
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
	 * 按状态查询订单个数
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
	 * 按状态查询订单
	 */
	@Override
	public List<Orders> findOrderByState(Integer state, int begin, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from orders where state = ? order by ordertime desc limit ?,?";
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class), state,begin,pageSize);
		return list;
	}

	/**
	 * 后台查询订单详情,返回订单项集合
	 * @throws SQLException 
	 */
	@Override
	public List<OrderItem> showDetail(String oid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from orders where oid = ?";
		Orders order = queryRunner.query(sql, new BeanHandler<Orders>(Orders.class), oid);
		//查找订单项，product.pid = orderitem.oid&orderitem.oid = order.oid;
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
	 * 模糊查询订单个数
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
	 * 模糊查询订单
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











