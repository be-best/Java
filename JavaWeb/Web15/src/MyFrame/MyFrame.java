package MyFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
		//���ô��ڴ�С
		myFrame.setBounds(0,0,200,300);
		myFrame.setName("����");
		//���ô�����ʾ
		myFrame.setVisible(true);
		//���ü�����
		myFrame.addWindowListener(new MyWindowListener());
	}
}

class MyWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�رմ���...");
		MyFrame myFrame = (MyFrame) e.getSource();
		System.out.println(myFrame.getName());
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
