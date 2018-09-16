package weblistener;
/**
 * ServletContextListener������
 */
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext���󱻴�����...");
		Timer timer = new Timer();
		/*Calendar calendar = Calendar.getInstance();
		calendar.set(2016,3,11,10,18,00);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("�����ʼ�:");
			}
		}, calendar.getTime(), 5000);*/
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("�����ʼ�:");
			}
		}, 10000, 2000);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}
