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
 * �����Ʒ
 * @author 45��ը
 *
 */
public class AdminAddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			//����һ��Product����
			Product product = new Product();
			//���������ļ����
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			//���û�������С
			diskFileItemFactory.setSizeThreshold(3*1024*1024);
			//��ú��Ľ�����
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			//��������ļ��ϴ�����
			fileUpload.setHeaderEncoding("UTF-8");
			//����request������list����
			List<FileItem> list = fileUpload.parseRequest(request);
			
			//����ļ���ÿһ���֣�����list����ֵ����map
			Map<String,String> map = new HashMap<String,String>();
			String fileName = null;
			int i = 1;
			for (FileItem fileItem : list) {
				//�ж����ļ��ϴ�������ͨ����
				if(fileItem.isFormField()) {
					//��ͨ����
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					System.out.println(name+"---"+value);
					map.put(name, value);
				} else {
					
					//�ļ��ϴ�
					fileName = fileItem.getName();//�ļ���
					List<String> listStr = new ArrayList<String>();
					String[] str = fileName.split("\\\\");
					fileName = str[str.length-1];
					System.out.println("�ļ���:"+fileName);
					//����ļ�������
					InputStream is = fileItem.getInputStream();
					//����ļ��ϴ�·��
					String path = this.getServletContext().getRealPath("/product");
					//д����
					OutputStream os = new FileOutputStream(path+"/"+fileName);
					byte[] b = new byte[1024];
					int length = 0;
					while((length = is.read(b)) != -1) {
						os.write(b, 0, length);
					}
					if(i == 1) {
						//i=1ʱ�����ƷͼƬ
						product.setPimage("product/"+fileName);
						i++;
					}
					if(i == 2) {
						//i=2ʱ�����Ʒ����ͼƬ
						product.setPdesc("product/"+fileName);
					}
					is.close();
					os.close();
				}
			}
			//��װ����
			BeanUtils.populate(product, map);//pname,market_price,shop_price,is_hot,desc
			//��Ҫ��װcategory,pid,pimage,pdate,pflag
			product.setPdate(new Date().toString());
			product.setPid(UUIDUtils.getUUID());
			product.setPflag(0);
			//product.setPimage("product/"+fileName);
			//product.setPdesc("product/"+fileName);
			Category category = new Category();
			category.setCid(map.get("cid"));
			product.setCategory(category);
			//����ҵ��㴦������
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






