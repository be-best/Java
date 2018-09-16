package bull02.JDBCconnectionPool;
/**
 * ʹ��װ���ߵķ�ʽ�����ķ�������ǿ
 * @author 45��ը
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
		System.out.println("����...");
		
	}
	
}

class WaiterressWrapper implements Waiter {

	private Waiter waiter;
	public WaiterressWrapper(Waiter waiter) {
		this.waiter = waiter;//����Waiter��waiter,ʱ��this.waiter���Waiteress���waiter
	}
	@Override
	public void server() {
		System.out.println("΢Ц...");
		this.waiter.server();////����Waiter��waiter,ʱ��this.waiter���Waiteress���waiter
	}
	
}
