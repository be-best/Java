package bull03.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������Ʒ����
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(name);
		//����map�������ڱ��湺����Ϣ��key����Ʒ��value�ǹ��������
		Map<String,Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		if(map == null) {
			//���Ϊ�գ�����һ��map����
			map = new LinkedHashMap<String, Integer>();
		}
		
		//���map�а�������Ϊname����Ʒ
		if(map.containsKey(name)) {
			//��ȡname��Ӧ��valueֵ����Ʒ����
			Integer count = map.get(name);
			//������+1��д��map��
			count++;
			map.put(name, count);
		} else {
			//���map��û��name����ô��nameд��ȥ
			map.put(name, 1);
		}
		
		//��map���ϱ��浽session��,����Ϊcart
		request.getSession().setAttribute("cart", map);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("<h3><a href='/Web11/cart/product_list.jsp'>��������</a>|<a href='/Web11/cart/cart.jsp'>���н���</a></h3>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
