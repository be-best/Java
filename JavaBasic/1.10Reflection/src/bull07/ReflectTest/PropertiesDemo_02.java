package bull07.ReflectTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.junit.Test;

import bull07.domain.BeanConfig;

/*
 * 解析Properties
 */
public class PropertiesDemo_02 {
	private static final int UTF = 0;

	@Test
	public void method() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		//创建一个BeanConfig对象
		BeanConfig beanConfig = new BeanConfig();
		/*
		 * 读取bean.properties数据，设置id和className属性。
		 * 也就是把bean.properties的数据配置到beanConfig对象属性中。
		 */
		//创建Properties对象
		Properties beanProp = new Properties();
		//用IO流读取bean.propties数据
		beanProp.load(new InputStreamReader(new FileInputStream("bean.properties"),"UTF-8"));
		//为beanConfig对象配置id和className,配置的数据从properties获取
		beanConfig.setId(beanProp.getProperty("id"));
		beanConfig.setClassName(beanProp.getProperty("className"));
		
		/*
		 * 读取data.properties数据，设置User数据
		 */
		Properties dataProp = new Properties();
		//读取data.properrties数据
		dataProp.load(new InputStreamReader(new FileInputStream("data.properties"),"UTF-8"));
		for (String key : dataProp.stringPropertyNames()) {
			String value = dataProp.getProperty(key);
			/*
			 * 为User配置数据
			 * beanConfih.getProp()其实就是获取了Properties对象，因为BeanConfig里有创建Properties对象。
			 */
			beanConfig.getProp().setProperty(key, value);
		}
		System.out.println(beanConfig);
	}
}
