package bull10.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class MyCollections {

	@SuppressWarnings({"unchecked","rawtypes"})
	public static List<String> unmodifiableList(final List<String> list) {
		//��Ŀ���ࣩlist ���й��ܶ���
		//�������ࣩproxyList ϣ�����ܽ�����ɾ�ģ�ֻ�ܲ�ѯ,����ʵ��proxyList��List����add���ܡ�
		
		//����һ��ClassLoader����̬������Ҫһ���������
		ClassLoader loader = MyCollections.class.getClassLoader();
		//��������Class[] interfaces,��Ҫ��Ŀ����ӿڱ���һ��
		Class[] interfaces = list.getClass().getInterfaces();
		
		
		List<String> proxyList = (List<String>) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//������ķ���ÿ������һ�Σ�������invoke������ִ��һ�Ρ�
				//������ǿ��--���������
				//1.��÷�����
				String methodName = method.getName();
				//2.������addʱ���쳣
				if(methodName.equals("add")) {
					throw new UnsupportedOperationException("�����������Ӳ�����");
				}
				
				//��������ֱ��ִ��Ŀ�����ж�Ӧ�ķ���
				return method.invoke(list, args);
			}
		});
		
		//���ش�����
		return proxyList;
	}

}
