package bull06.XMLTest;

import java.util.Properties;
/*
 * BeanConfig用于封装存储从XML中获取的数据
 */
public class BeanConfig {
	private String id;
	private String className;
	private Properties prop = new Properties();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	@Override
	public String toString() {
		return "BeanConfig [id=" + id + ", className=" + className + ", prop="
				+ prop + "]";
	}
	
	
}
