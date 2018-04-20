package bull05.DBSelectUtils;
/*
 * JavaBean�淶��
 * 	1.�ṩ˽���ֶ�
 *  2.Ϊ˽���ֶ��ṩgetter/setter����
 *  3.�޲ι���
 *  4.ʵ�����л��ӿڣ�implements java.io.Serializable
 */
public class ProductJavaBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6968409272670177143L;
	private String pid;		//���
	private String pname;	//����
	private String price;	//�۸�
	private String category_id; //��������
	
	
	public ProductJavaBean(String pid, String pname, String price, String category_id) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.category_id = category_id;
	}
	
	public ProductJavaBean() {
		
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "ProductJavaBean [pid=" + pid + ", pname=" + pname + ", price=" + price
				+ ", category_id=" + category_id + "]";
	}
	
	
}
