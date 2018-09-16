package com.store.domain;

import java.util.Date;

/**
 * ��Ʒ��ʵ��:
 * @author admin
 * 
 */
public class Product {
	private String pid; //��ƷID
	private String pname; //��Ʒ����
	private Double market_price; //��Ʒ�г���
	private Double shop_price; //��Ʒ�̳Ǽ�
	private String pimage; //��ƷͼƬ
	private String pdate; //��������
	private Integer is_hot; //�Ƿ�����
	private String pdesc; //����Ʒ ��
	private Integer pflag; //�Ƿ��ϼ�
	//cid������������������category,����cid
	// һ�Զ�Ĺ�ϵ�ڱ�����ͨ������ķ�ʽ����,����������Java�������.
	// Hibernate��ܣ�ORM��DAO���� .ORM:Object-Relational Mapping  session.save(product);
	private Category category; //��Ʒ����
	
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
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getPflag() {
		return pflag;
	}
	public void setPflag(Integer pflag) {
		this.pflag = pflag;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}