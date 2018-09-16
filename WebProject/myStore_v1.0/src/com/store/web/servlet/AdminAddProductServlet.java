package com.store.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.store.domain.Category;
import com.store.domain.Product;
import com.store.service.ProductService;
import com.store.utils.BeanFactory;
import com.store.utils.UUIDUtils;
/**
 * 添加商品
 * @author 45度炸
 *
 */
public class AdminAddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			//创建一个Product对象
			Product product = new Product();
			//创建磁盘文件项工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			//设置缓存区大小
			diskFileItemFactory.setSizeThreshold(3*1024*1024);
			//获得核心解析类
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			//解决中文文件上传乱码
			fileUpload.setHeaderEncoding("UTF-8");
			//解析request，返回list集合
			List<FileItem> list = fileUpload.parseRequest(request);
			
			//获得文件的每一部分，遍历list，键值存入map
			Map<String,String> map = new HashMap<String,String>();
			String fileName = null;
			int i = 1;
			for (FileItem fileItem : list) {
				//判断是文件上传还是普通数据
				if(fileItem.isFormField()) {
					//普通数据
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					System.out.println(name+"---"+value);
					map.put(name, value);
				} else {
					
					//文件上传
					fileName = fileItem.getName();//文件名
					List<String> listStr = new ArrayList<String>();
					String[] str = fileName.split("\\\\");
					fileName = str[str.length-1];
					System.out.println("文件名:"+fileName);
					//获得文件输入流
					InputStream is = fileItem.getInputStream();
					//获得文件上传路径
					String path = this.getServletContext().getRealPath("/product");
					//写数据
					OutputStream os = new FileOutputStream(path+"/"+fileName);
					byte[] b = new byte[1024];
					int length = 0;
					while((length = is.read(b)) != -1) {
						os.write(b, 0, length);
					}
					if(i == 1) {
						//i=1时添加商品图片
						product.setPimage("product/"+fileName);
						i++;
					}
					if(i == 2) {
						//i=2时添加商品描述图片
						product.setPdesc("product/"+fileName);
					}
					is.close();
					os.close();
				}
			}
			//封装数据
			BeanUtils.populate(product, map);//pname,market_price,shop_price,is_hot,desc
			//还要封装category,pid,pimage,pdate,pflag
			product.setPdate(new Date().toString());
			product.setPid(UUIDUtils.getUUID());
			product.setPflag(0);
			//product.setPimage("product/"+fileName);
			//product.setPdesc("product/"+fileName);
			Category category = new Category();
			category.setCid(map.get("cid"));
			product.setCategory(category);
			//调用业务层处理数据
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			productService.addProduct(product);
			//productService.updateProduct(product);
			
			response.sendRedirect(request.getContextPath()+"/AdminProductServlet?method=findByPage&currPage=1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}






