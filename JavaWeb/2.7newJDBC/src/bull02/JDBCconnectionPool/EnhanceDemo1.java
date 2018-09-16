package bull02.JDBCconnectionPool;
/**
 * 使用装饰者的方式完成类的方法的增强
 * @author 45度炸
 *
 */
public class EnhanceDemo1 {
	public static void main(String[] args) {
		Waiter waiter = new Waiteress();
		Waiter waiterresswraper = new WaiterressWrapper(waiter);
		waiterresswraper.server();
	}
}

interface Waiter {
	public void server();
}

class Waiteress implements Waiter {

	@Override
	public void server() {
		System.out.println("服务...");
		
	}
	
}

class WaiterressWrapper implements Waiter {

	private Waiter waiter;
	public WaiterressWrapper(Waiter waiter) {
		this.waiter = waiter;//传入Waiter的waiter,时的this.waiter变成Waiteress类的waiter
	}
	@Override
	public void server() {
		System.out.println("微笑...");
		this.waiter.server();////传入Waiter的waiter,时的this.waiter变成Waiteress类的waiter
	}
	
}
