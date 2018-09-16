package bull01.Product.ProductDomain;

import java.util.List;

public class PageBean {
	private int currPage;// 当前页数
	private int totalCount;//总记录数
	private int totalPage;//总页数
	private int pageSize; //每页记录数
	private List<Product> list;//每页的数据集合
	
	public PageBean() {
		
	}
	
	public PageBean(int currPage, int totalCount, int totalPage, int pageSize,
			List<Product> list) {
		this.currPage = currPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.list = list;
	}
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	
}
