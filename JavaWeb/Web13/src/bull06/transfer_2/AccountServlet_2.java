package bull06.transfer_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull04.transfer.AccountService;

public class AccountServlet_2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//��������
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		Double money = Double.parseDouble(request.getParameter("money")) ;
		//����ҵ��㴦������
		AccountService accountService = new AccountService();
		accountService.transfer(from,to,money);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
