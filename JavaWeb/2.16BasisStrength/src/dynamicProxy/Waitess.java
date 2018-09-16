package dynamicProxy;

public class Waitess implements Waiter {

	@Override
	public void server() {
		System.out.println("ЗўЮёжа...");
		
	}

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		//System.out.println("Hello:"+name);
		return "Hello:"+name;
	}

	
}
