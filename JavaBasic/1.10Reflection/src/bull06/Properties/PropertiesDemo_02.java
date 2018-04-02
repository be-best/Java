package bull06.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import org.junit.Test;

/*
 * 将内容写入文件
 */
public class PropertiesDemo_02 {
	@Test
	public void method1() throws Exception {
		//创建对象
		Properties prop = new Properties();
		//设置数据
		prop.setProperty("k1", "v1");
		prop.setProperty("k2", "v2");
		prop.setProperty("k3", "v3");
		
		//把数据写入文件
		Writer writer = new OutputStreamWriter(new FileOutputStream("prop.txt"),"UTF-8");
		prop.store(writer, "this is file-introduce");
		writer.close();
		
		//采用BufferedWriter方式
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("prop1.txt"),"UTF-8"));
//		prop.store(bw, "描述");
//		bw.close();
	}
	
	@Test
	public void method2() throws Exception, FileNotFoundException {
		//创建对象
		Properties prop = new Properties();
		
		//通过properties对象加载流
		Reader reader = new InputStreamReader(new FileInputStream("prop.txt"),"UTF-8");
		prop.load(reader);
		reader.close();
		
		//遍历输出到控制台
		for (String name : prop.stringPropertyNames()) {
			String value = prop.getProperty(name);
			System.out.println(name + "@" + value);
		}
	}
}
