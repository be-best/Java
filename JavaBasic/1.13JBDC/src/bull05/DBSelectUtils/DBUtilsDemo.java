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
		//BeanHandler:��������е�һ����¼��װ��һ��ָ����javaBean�С�
		/*
		 * ��ѯ���ݱ�������������һ�ַ�ʽ:
		 *   BeanHandler����ʽ
		 *     �����ݱ�Ľ������һ������,��װ��JavaBean��Ķ���
		 *   ���췽��:
		 *    BeanHandler(Class<T> type) 
		 *    ����һ��Class���Ͷ���,�������װ���ĸ���Ķ�����
		 *    ZhangWu���Class����
		 */
		//1.������
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.SQL���
		String sql = "select * from product where pid = ?;";
		//3.ʵ�ʲ���
		Object[] parms = {10};
		//4.��װ��ѯ,BeanHandler�����ǽ����ݷ�װ��ProductJavaBean���JavaBean�С�����Ҫ��ȡProjectJavaBean.class����ֽ����ļ���
		ProductJavaBean product = queryRunner.query(sql, new BeanHandler<ProductJavaBean>(ProductJavaBean.class), parms);
		System.out.println(product);//ProductJavaBean [pid=10, pname=���, price=5, category_id=c003]

	}
//	@Test
//	public void findById() throws SQLException {
//		// ��ѯ
//		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
//		String sql = "select * from products where pid = ?;";
//		Object[] params = {10};
//		//����ѯ�����ݷ�װ��Product���JavaBean�С�
//		ProductJavaBean product = queryRunner.query(sql, new BeanHandler<ProductJavaBean>(ProductJavaBean.class), params);
//		System.out.println(product);
//	}
	
	@Test
	public void demo2() throws SQLException {
		//BeanListHandler:��ѯ���У���ÿһ����¼��װ��JavaBean�У�Ȼ��JavaBean�ӵ�List�У���󷵻�List
		/*
		 * ��ѯ���ݱ�������������һ�ַ�ʽ:
		 *   BeanListHandler����ʽ
		 *     �����ݱ��ÿһ������,��װ��JavaBean�����
		 *     ����������,���JavaBean����,�洢List����
		 */
		//1.������
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql���
		String sql = "select * from product;";
		//3.ʵ�ʲ���
		Object[] parms = {};
		//4.ִ��
		List<ProductJavaBean> list = queryRunner.query(sql, new BeanListHandler<ProductJavaBean>(ProductJavaBean.class), parms);
		for (ProductJavaBean productJavaBean : list) {
			System.out.println(productJavaBean);
		}
	}
	
	@Test
	public void demo3() throws SQLException {
		//ScalarHandler�����ڴ���ۺϺ���ִ�н����һ��һ�У�
		//��ѯ�ܼ�¼��
		/*
		 * ��ѯ���ݱ�������������һ�ַ�ʽ:
		 *    ScalarHandler����ʽ
		 *     ����ֵ��ѯ���,ִ�е�select����,�����ֻ��1��
		 */
		//������
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//sql
		String sql = "select count(*) from product;";
		//ִ��
		//Object obj = queryRunner.query(sql, new ScalarHandler<ProductJavaBean>());
		long obj = queryRunner.query(sql, new ScalarHandler<Long>());
		System.out.println(obj);//13
	}
	
	@Test
	public void demo4() throws SQLException {
		//MapHandler:����ѯ��һ����¼��װ��Map�С�map.key = ����map.value = ֵ��
		//��Ҫ��;����������������ת��Ϊjson��
		/*
		 * ��ѯ���ݱ�������������һ�ַ�ʽ:
		 *   MapHandler����ʽ
		 *     �����ݱ������ĵ�һ������,��װ��Map����
		 *   ��: ���ݱ��е���
		 *   ֵ: ������е�����
		 *   
		 *   ����ʽ��Map����,��LinkedHashMap������
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid = ?;";
		Object[] parms = {9};
		Map<String,Object> map = queryRunner.query(sql, new MapHandler(), parms);
		System.out.println(map);//{pid=9, pname=���˱���, price=200.0, category_id=c003}
	}
	
	@Test
	public void demo5() throws SQLException {
		//MapListHandler:��ѯ�������ݣ������ݷ�װ��Map�У�Ȼ��Map��ӵ�List�С�
		//��Ҫ��;����������
		/*
		 * ��ѯ���ݱ���������һ�ִ���ʽ:
		 *   MapListHandler����ʽ
		 *     �����ݱ�Ľ������ÿһ�з�װ��Map����
		 *     ���ݱ��������,���ֶ��Map����,�洢List����
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
		//ArrarHandler:��ѯһ����¼�������ݷ�װ��������
		/*
		 *  ��ѯ���ݱ�������������һ�ַ�ʽ:
		 *  ArrayHandler����ʽ
		 *    �����ݱ��еĵ�һ������,�洢����������Object[]��
		 *  
		 *  ע��: ��ȡ��ѯ��ĵ�һ������,�����ѯ���������,���صĶ��������length=0
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid = ?;";
		Object[] parms = {1};
		Object[] obj = queryRunner.query(sql, new ArrayHandler(), parms);
			System.out.println(obj);//[Ljava.lang.Object;@662f743b
			System.out.println(Arrays.toString(obj));//[1, ����, 5000.0, c001]
	}

	@Test
	public void demo7() throws SQLException {
		//ArrayListHandler:��ѯ�������ݣ������ݷ�װ�������У�Ȼ��ӵ�List����󷵻�List
		/*
		 * ��ѯ���ݱ�������������һ�ַ�ʽ:
		 * ArrayListHandler����ʽ
		 *  �����ݱ��е�ÿһ������,�洢��һ����������Object[]��
		 *  �����ݱ��л��ж�������,���������������, �洢��List������
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
		//KeyedHandler:new KeyedHandler("�ֶ�����"),��ѯ���У�����ѯ�����װ��Map�С�
		// * map.key=Ϊָ�����ֶ����ơ���Ӧ��ֵ
		// * map.value=Ϊ��ǰ������¼���е�ֵ������ΪMap<�ֶ���,ֵ>
		// ����  Map<String , Map<String,Object> >
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
		//ColumnListHandler:��ѯָ��һ������
		/*
		 * ��ѯ���ݱ�������������һ�ַ�ʽ:
		 *   ColumnListHandler����ʽ
		 *     ����ѯ���ݱ������е�ĳһ������,�洢��List����
		 *     �ĸ��в����,��������Ҳ�����, List<Object>
		 *  ColumnListHandler���췽��
		 *    �ղ���: ��ȡ�������ݱ�ĵ�һ��
		 *    int����: �����е�˳����
		 *    String����: ��������
		 *    
		 *  ��������,���Լ��뷺��,���Ǽ������������,Ҫ�Ͳ�ѯ��������һ��
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid = ?;";
		Object[] parms = {5};
		List<Object> list1 = queryRunner.query(sql, new ColumnListHandler("pid"), parms);
		List<Object> list2 = queryRunner.query(sql, new ColumnListHandler("pname"), parms);
		List<Object> list3 = queryRunner.query(sql, new ColumnListHandler("price"), parms);
		List<Object> list4 = queryRunner.query(sql, new ColumnListHandler("category_id"), parms);
		System.out.println(list1);//[5]
		System.out.println(list2);//[��ά˹]
		System.out.println(list3);//[200.0]
		System.out.println(list4);//[c002]
 	}
}
