package bull.domain;

/*
 * JavaBean规范：
 * 	1.提供私有字段
 *  2.为私有字段提供getter/setter方法
 *  3.无参构造
 *  4.实现序列化接口：implements java.io.Serializable
 */
public class Product implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6968409272670177143L;
	private Integer pid;		//编号
	private String pname;	//名称
	private Integer price;	//价格
	private String flag;    //上架标记
	private String category_id; //分类名称
	
	
	public Product(Integer pid, String pname, Integer price, String flag,String category_id) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.flag = flag;
		this.category_id = category_id;
	}
	
	public Product() {
		
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price
				+ ", flag=" + flag + ", category_id=" + category_id + "]";
	}
	
	
}

///*
// * JavaBean文件
// */
//public class Product implements java.io.Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 5191604074305952749L;
//	private Integer pid;
//	private String pname;
//	private Integer price;
//	private String flag;
//	private String category_id;
//	
//	public Product() {
//		
//	}
//	
//	public Product(Integer pid,String pname, Integer price, String flag,
//			String category_id) {
//		this.pid = pid;
//		this.pname = pname;
//		this.price = price;
//		this.flag = flag;
//		this.category_id = category_id;
//	}
//	
//	public Integer getPid() {
//		return pid;
//	}
//	public void setPid(Integer pid) {
//		this.pid = pid;
//	}
//	public String getName() {
//		return pname;
//	}
//	public void setName(String pname) {
//		this.pname = pname;
//	}
//	public Integer getPrice() {
//		return price;
//	}
//	public void setPrice(Integer price) {
//		this.price = price;
//	}
//	public String getFlag() {
//		return flag;
//	}
//	public void setFlag(String flag) {
//		this.flag = flag;
//	}
//	public String getCategory_id() {
//		return category_id;
//	}
//	public void setCategory_id(String category_id) {
//		this.category_id = category_id;
//	}
//	@Override
//	public String toString() {
//		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price
//				+ ", flag=" + flag + ", category_id=" + category_id + "]";
//	}
//	
//	
//}
