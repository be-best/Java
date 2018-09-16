package bull.Utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

	public static Cookie find(Cookie[] cookies, String name) {
		if(cookies == null) {
			return null;
		} else {
			//�ҵ�����Ϊname��cookie
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}

}
