package bull05.DBSelectUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import bull.domain.Product;
import bull.utils.JDBCUtils;
import bull05.DBUtils.C3P0Utils;

public class DBUtilsDemo {
	@Test
	public void demo() throws SQLException {
		//BeanHandler:将结果集中第一条记录封装到一个指定的javaBean中。
		/*
		 * 查询数据表结果集处理其中一种方式:
		 *   BeanHandler处理方式
		 *     将数据表的结果集第一行数据,封装成JavaBean类的对象
		 *   构造方法:
		 *    BeanHandler(Class<T> type) 
		 *    传递一个Class类型对象,将结果封装到哪个类的对象呢
		 *    ZhangWu类的Class对象
		 */
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.SQL语句
		String sql = "select * from product where pid = ?;";
		//3.实际参数
		Object[] parms = {10};
		//4.封装查询,BeanHandler作用是将数据封装到ProductJavaBean这个JavaBean中。所以要获取ProjectJavaBean.class这个字节码文件。
		ProductJavaBean product = queryRunner.query(sql, new BeanHandler<ProductJavaBean>(ProductJavaBean.class), parms);
		System.out.println(product);//ProductJavaBean [pid=10, pname=面霸, price=5, category_id=c003]

	}
//	@Test
//	public void findById() throws SQLException {
//		// 查询
//		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
//		String sql = "select * from products where pid = ?;";
//		Object[] params = {10};
//		//将查询的数据封装到Product这个JavaBean中。
//		ProductJavaBean product = queryRunner.query(sql, new BeanHandler<ProductJavaBean>(ProductJavaBean.class), params);
//		System.out.println(product);
//	}
	
	@Test
	public void demo2() throws SQLException {
		//BeanListHandler:查询所有，将每一条记录封装到JavaBean中，然后将JavaBean加到List中，最后返回List
		/*
		 * 查询数据表结果集处理其中一种方式:
		 *   BeanListHandler处理方式
		 *     将数据表的每一行数据,封装成JavaBean类对象
		 *     多行数据了,多个JavaBean对象,存储List集合
		 */
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select * from product;";
		//3.实际参数
		Object[] parms = {};
		//4.执行
		List<ProductJavaBean> list = queryRunner.query(sql, new BeanListHandler<ProductJavaBean>(ProductJavaBean.class), parms);
		for (ProductJavaBean productJavaBean : list) {
			System.out.println(productJavaBean);
		}
	}
	
	@Test
	public void demo3() throws SQLException {
		//ScalarHandler：用于处理聚合函数执行结果（一行一列）
		//查询总记录数
		/*
		 * 查询数据表结果集处理其中一种方式:
		 *    ScalarHandler处理方式
		 *     处理单值查询结果,执行的select语句后,结果集只有1个
		 */
		//核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//sql
		String sql = "select count(*) from product;";
		//执行
		//Object obj = queryRunner.query(sql, new ScalarHandler<ProductJavaBean>());
		long obj = queryRunner.query(sql, new ScalarHandler<Long>());
		System.out.println(obj);//13
	}
	
	@Test
	public void demo4() throws SQLException {
		//MapHandler:将查询的一条记录封装到Map中。map.key = 键，map.value = 值。
		//主要用途：多表操作，将数据转换为json等
		/*
		 * 查询数据表结果集处理其中一种方式:
		 *   MapHandler处理方式
		 *     将数据表结果集的第一行数据,封装成Map集合
		 *   键: 数据表中的列
		 *   值: 这个列中的数据
		 *   
		 *   处理方式的Map集合,是LinkedHashMap的子类
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid = ?;";
		Object[] parms = {9};
		Map<String,Object> map = queryRunner.query(sql, new MapHandler(), parms);
		System.out.println(map);//{pid=9, pname=相宜本草, price=200.0, category_id=c003}
	}
	
	@Test
	public void demo5() throws SQLException {
		//MapListHandler:查询所有数据，将数据封装到Map中，然后将Map添加到List中。
		//主要用途：多表操作等
		/*
		 * 查询数据表结果集其中一种处理方式:
		 *   MapListHandler处理方式
		 *     将数据表的结果集的每一行封装成Map集合
		 *     数据表多行数据,出现多个Map集合,存储List集合
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product;";
		List<Map<String,Object>> list = queryRunner.query(sql, new MapListHandler());
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}

	@Test
	public void demo6() throws SQLException {
		//ArrarHandler:查询一条记录，将数据封装到数组中
		/*
		 *  查询数据表结果集处理其中一种方式:
		 *  ArrayHandler处理方式
		 *    将数据表中的第一行数据,存储到对象数组Object[]中
		 *  
		 *  注意: 获取查询后的第一行数据,如果查询不到结果集,返回的对象数组的length=0
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid = ?;";
		Object[] parms = {1};
		Object[] obj = queryRunner.query(sql, new ArrayHandler(), parms);
			System.out.println(obj);//[Ljava.lang.Object;@662f743b
			System.out.println(Arrays.toString(obj));//[1, 联想, 5000.0, c001]
	}

	@Test
	public void demo7() throws SQLException {
		//ArrayListHandler:查询所有数据，将数据封装到数组中，然后加到List，最后返回List
		/*
		 * 查询数据表结果集处理其中一种方式:
		 * ArrayListHandler处理方式
		 *  将数据表中的每一行数据,存储到一个对象数组Object[]中
		 *  而数据表中会有多行数据,产生多个对象数组, 存储到List集合中
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product;";
		List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}
	
	@Test
	public void demo8() throws SQLException {
		//KeyedHandler:new KeyedHandler("字段名称"),查询所有，将查询结果封装到Map中。
		// * map.key=为指定“字段名称”对应的值
		// * map.value=为当前整条记录所有的值，数据为Map<字段名,值>
		// 类型  Map<String , Map<String,Object> >
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product;";
		Map<String,Map<String,Object>> map = queryRunner.query(sql, new KeyedHandler<String>("pname"));
		for (Map.Entry<String, Map<String,Object>> entry:map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
	
	@Test
	public void demo9() throws SQLException {
		//ColumnListHandler:查询指定一列数据
		/*
		 * 查询数据表结果集处理其中一种方式:
		 *   ColumnListHandler处理方式
		 *     将查询数据表结果集中的某一列数据,存储到List集合
		 *     哪个列不清楚,数据类型也不清楚, List<Object>
		 *  ColumnListHandler构造方法
		 *    空参数: 获取就是数据表的第一列
		 *    int参数: 传递列的顺序编号
		 *    String参数: 传递列名
		 *    
		 *  创建对象,可以加入泛型,但是加入的数据类型,要和查询的列类型一致
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid = ?;";
		Object[] parms = {5};
		List<Object> list1 = queryRunner.query(sql, new ColumnListHandler("pid"), parms);
		List<Object> list2 = queryRunner.query(sql, new ColumnListHandler("pname"), parms);
		List<Object> list3 = queryRunner.query(sql, new ColumnListHandler("price"), parms);
		List<Object> list4 = queryRunner.query(sql, new ColumnListHandler("category_id"), parms);
		System.out.println(list1);//[5]
		System.out.println(list2);//[真维斯]
		System.out.println(list3);//[200.0]
		System.out.println(list4);//[c002]
 	}
}
