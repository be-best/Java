package Async;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 异步请求的Servlet
 */

public class AsyncServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AsyncContext context = request.startAsync(request, response);
		context.start(new MyRunnable(context));
		//输出1-10
		for(int i = 0;i < 10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}


class MyRunnable implements Runnable {

	private AsyncContext context;

	public MyRunnable(AsyncContext context) {
		this.context = context;
	}
	
	@Override
	//输出a-z
	public void run() {
		for(char i='a';i < 'z';i++) {
			try {
				context.getResponse().getWriter().print(i);
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}