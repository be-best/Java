package bull02.Ajax.AjaxService;

import java.sql.SQLException;

import bull02.Ajax.AjaxDao.AjaxDao;
import bull02.Ajax.domain.User;

public class AjaxService {

	public User findUser(String username) throws SQLException {
		AjaxDao ajaxDao = new AjaxDao();
		User user = ajaxDao.findUser(username);
		return user;
	}

}
