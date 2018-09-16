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
		//接收商品名称
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(name);
		//创建map集合用于保存购物信息，key是商品，value是购买的数量
		Map<String,Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		if(map == null) {
			//如果为空，创建一个map集合
			map = new LinkedHashMap<String, Integer>();
		}
		
		//如果map中包含名称为name的商品
		if(map.containsKey(name)) {
			//获取name对应的value值：商品数量
			Integer count = map.get(name);
			//对数量+1并写回map中
			count++;
			map.put(name, count);
		} else {
			//如果map中没有name，那么把name写进去
			map.put(name, 1);
		}
		
		//将map集合保存到session中,命名为cart
		request.getSession().setAttribute("cart", map);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("<h3><a href='/Web11/cart/product_list.jsp'>继续购物</a>|<a href='/Web11/cart/cart.jsp'>进行结算</a></h3>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
