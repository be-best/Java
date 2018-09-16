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
 * * ������Ʒid.
 * * ���մӿͻ��˴�����������Cookie.
 * * ��Cookie�������в���ָ�����Ƶ�Cookie.
 * * �ж��Ƿ��ǵ�һ�������Ʒ:
 *     * ��һ�������Ʒ
 *        * ֱ�ӽ���Ʒ��ID���뵽Cookie.
 *        * ��Cookie��д�������.
 *     * ���ǵ�һ�������Ʒ 1-2
 *        * �жϵ�ǰ����Ʒ�Ƿ��Ѿ��������¼.
 *            * �Ѿ�����: 2-1 �Ƴ���ǰԪ�أ�����ǰԪ����ӵ��ʼ.
 *            * û�������¼��: 
 *                * �ж��Ƿ��Ѿ���������󳤶�:������� 2-1-3:ɾ�����һ�� ����ǰԪ����ӵ���ǰ��.
 *                * û�г���:ֱ�ӽ���Ԫ����ӵ���ǰλ��.
 *        * ��ת����id��ֵ���뵽Cookie,��д�����.
 * @author 45��ը
 *
 */
public class ProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������ƷID
		String id = request.getParameter("id");
		//��ȡCookie��Ϣ
		Cookie[] cookies = request.getCookies();
		//��Cookie�����в���ָ�����Ƶ�cookie,���Ҫ�ҵ���history
		Cookie cookie = CookieUtils.find(cookies, "history");
		
		if(cookie == null) {
			//���cookie��û�ж������id����history���cookie��
			Cookie c = new Cookie("history",id);
			c.setPath("/Web11");
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		} else {
			//���history���cookie������ֵ
			String value = cookie.getValue();
			//��value(1-2-3-4)����ַ�����"-"�ָ��[1,2,3,4]
			String[] ids = value.split("-");
			LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
		
				//�����Ʒ�������¼��
				if(list.contains(id)) {
					//��ȥԭ��¼������ӵ���һ����
					list.remove(id);
					list.addFirst(id);
				} else {
					//�����Ʒ���������¼��
					if(list.size() >= 3) {
						//��¼���ڵ�������ʱ��ɾ�����һ����¼�������һ���µļ�¼
						list.removeLast();
						list.addFirst(id);
					} else {
						list.addFirst(id);
				}
			}
			//��listԪ��ȡ��������"-"���ӱ��浽Cookie��д�������
			StringBuffer sb = new StringBuffer();
			for (String string : list) {
				sb.append(string).append("-");
			}
			//�����һ��"-"ȥ��:(1-2-3-)-->(1-2-3)
			String cookieValue = sb.toString().substring(0,sb.length()-1);
			System.out.println(cookieValue);
			//д�������
			Cookie c = new Cookie("history",cookieValue);
			c.setPath("/Web11");
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		}
		//ת��������Ʒ����ҳ
		request.getRequestDispatcher("/history/product_info.htm").forward(request, response);;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}

