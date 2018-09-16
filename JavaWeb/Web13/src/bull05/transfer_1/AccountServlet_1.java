package bull05.transfer_1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull04.transfer.AccountService;

public class AccountServlet_1 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//接收数据
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		Double money = Double.parseDouble(request.getParameter("money")) ;
		//调用业务层处理数据
		AccountService accountService = new AccountService();
		accountService.transfer(from,to,money);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
