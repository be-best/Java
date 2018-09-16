package bull02.Ajax.AjaxService;

import java.sql.SQLException;
import java.util.List;

import bull02.Ajax.AjaxDao.ContentDao;
import bull02.Ajax.domain.Content;

public class ContentService {

	public List<Content> findContent(String content) throws SQLException {
		ContentDao contentDao = new ContentDao();
		return contentDao.findContent(content);
	}

}
