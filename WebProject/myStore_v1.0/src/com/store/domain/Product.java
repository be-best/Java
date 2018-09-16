package com.store.domain;

import java.util.Date;

/**
 * 商品的实体:
 * @author admin
 * 
 */
public class Product {
	private String pid; //商品ID
	private String pname; //商品名称
	private Double market_price; //商品市场价
	private Double shop_price; //商品商城价
	private String pimage; //商品图片
	private String pdate; //添加日期
	private Integer is_hot; //是否热门
	private String pdesc; //描商品 述
	private Integer pflag; //是否上架
	//cid在这里是外键，这边用category,不用cid
	// 一对多的关系在表中是通过外键的方式描述,开发语言是Java面向对象.
	// Hibernate框架：ORM的DAO层框架 .ORM:Object-Relational Mapping  session.save(product);
	private Category category; //商品分类
	
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
