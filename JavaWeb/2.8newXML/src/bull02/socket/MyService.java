package bull02.socket;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MyService implements Runnable{

	private Socket socket;

	public MyService(Socket socket) throws Exception {
		this.socket = socket;
	}

	@Override
	public void run() {
		// �ṩ����
		try{
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String firstLine = reader.readLine();
			System.out.println(firstLine);
			String path = firstLine.split(" ")[1];
			System.out.println(path);
			// ���ļ����� �������д 
			File file = new File("webapps"+path);
			FileInputStream fis = new FileInputStream(file);
			
			OutputStream os = socket.getOutputStream();
			os.write("HTTP/1.1 200 OK\r\n".getBytes());
			os.write("\r\n".getBytes());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer))!=-1) {
				os.write(buffer, 0, len);
			}
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
