package bull01.MyBeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/*
 * BeanUtils�Զ��幤����
 */
public class MyBeanUtilsDemo_01 {
	/*
	 * Class<T> �˴���T����һ��������������ʱ���վ������͡����磺User
	 * ���������ȶ�����ʹ��
	 * 		���ͱ����Ķ��巽ʽ�����η� <������> ����ֵ��
	 * 		��������ķ�����static <User> User
	 */
	@Test
	public static <User> User populate(Class <User> beanClass,Map<String,String[]> properties) {
		//��̬������TestTool�������Ǳ�ֱ������������
		try {
			//���÷��䴴��ʵ����beanClass��һ�������
			User obj = beanClass.newInstance();
			//�������
			BeanUtils.populate(obj , properties);
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
