package bull02.VisitHistoty;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull.Utils.CookieUtils;
/**
 * 
 * * 接收商品id.
 * * 接收从客户端带过来的所有Cookie.
 * * 从Cookie的数组中查找指定名称的Cookie.
 * * 判断是否是第一次浏览商品:
 *     * 第一次浏览商品
 *        * 直接将商品的ID存入到Cookie.
 *        * 将Cookie回写到浏览器.
 *     * 不是第一次浏览商品 1-2
 *        * 判断当前的商品是否已经在浏览记录.
 *            * 已经存在: 2-1 移除当前元素，将当前元素添加到最开始.
 *            * 没在浏览记录中: 
 *                * 判断是否已经超过了最大长度:如果超过 2-1-3:删除最后一个 将当前元素添加到最前面.
 *                * 没有超过:直接将该元素添加到最前位置.
 *        * 将转换的id的值存入到Cookie,回写浏览器.
 * @author 45度炸
 *
 */
public class ProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收商品ID
		String id = request.getParameter("id");
		//获取Cookie信息
		Cookie[] cookies = request.getCookies();
		//从Cookie数组中查找指定名称的cookie,这边要找的是history
		Cookie cookie = CookieUtils.find(cookies, "history");
		
		if(cookie == null) {
			//如果cookie中没有东西则把id加入history这个cookie中
			Cookie c = new Cookie("history",id);
			c.setPath("/Web11");
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		} else {
			//获得history这个cookie的所有值
			String value = cookie.getValue();
			//将value(1-2-3-4)这个字符串以"-"分割开成[1,2,3,4]
			String[] ids = value.split("-");
			LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
		
				//如果商品在浏览记录里
				if(list.contains(id)) {
					//除去原纪录，并添加到第一个。
					list.remove(id);
					list.addFirst(id);
				} else {
					//如果商品不在浏览记录里
					if(list.size() >= 3) {
						//记录大于等于三个时，删掉最后一个记录，再添加一个新的记录
						list.removeLast();
						list.addFirst(id);
					} else {
						list.addFirst(id);
				}
			}
			//将list元素取出来，用"-"连接保存到Cookie中写回浏览器
			StringBuffer sb = new StringBuffer();
			for (String string : list) {
				sb.append(string).append("-");
			}
			//将最后一个"-"去掉:(1-2-3-)-->(1-2-3)
			String cookieValue = sb.toString().substring(0,sb.length()-1);
			System.out.println(cookieValue);
			//写回浏览器
			Cookie c = new Cookie("history",cookieValue);
			c.setPath("/Web11");
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		}
		//转发跳到商品详情页
		request.getRequestDispatcher("/history/product_info.htm").forward(request, response);;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}

