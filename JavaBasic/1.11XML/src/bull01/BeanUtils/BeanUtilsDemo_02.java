package bull01.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/*
 * ģ������
 */
public class BeanUtilsDemo_02 {
	@Test
	public void method() throws Exception, InvocationTargetException {
		//����һ��Map����,�����Ҫ������
		Map<String,String[]> map = new HashMap();
		map.put("userName", new String[]{"����"});
		map.put("userId", new String[]{"����"});
		map.put("userPasswd", new String[]{"����"});
		map.put("userHobby", new String[]{"������","������"});
		map.put("userAge", new String[]{"10"});
		
		//����User����
		User users = new User();
		/*
		 * ʹ��populate()�������:
		 * 	1.������ָ�����������һ�����ݣ����ͱ���������[];
		 * 	2.������Բ������飬��ʹ��map.value��ʾ�����еĵ�һ����
		 * 		���磺usrId���Բ������顣
		 * 			����map.put("userId", new String[]{"����","����"});��Ĭ�����ġ�
		 * 	3.BeanUtils֧�����ͣ��������ͺͻ������Ͷ�Ӧ�İ�װ��,�Զ����ַ���ת���������͡�
		 * 		���磺userAge��int�ͣ�
		 * 			map.put("userAge", new String[]{"10"})��Ĭ��ת��"10"��
		 */
		BeanUtils.populate(users, map);
		
		System.out.println(users);
	}
}
