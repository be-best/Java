package bull02.ThreadImpelement;

public class MyThread extends Thread{
	//÷ÿ–¥run∑Ω∑®
	@Override
	public void run() {
		for(int x = 0;x < 100;x++) {
			System.out.println(getName() + ":" +x);
		}
	}
}
