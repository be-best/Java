package bull04.UserLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/*
 * 服务端
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//1.创建服务端Socket对象
		ServerSocket ss = new ServerSocket(4738);
		//2.监听（阻塞）
		Socket s = ss.accept();
		//3.获取输入流对象,采用转换流InputStreamReader把字节流s.getInputStream()转换为字符流
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//获取数据
		String userName = br.readLine();
		String userPasswd = br.readLine();
		
		//4.判断用户名密码是否正确
		boolean flag = true;
		//获取数据库集合。集合中存储的是所有用户信息。
		List<User> userDB = UserDB.getUser();
		//以从客户端获取的用户名和密码新建一个User对象
		User user = new User(userName,userPasswd);
		//用contains方法判断数据库集合中是否含有此对象,记得重写用户类的equals方法
		if(userDB.contains(user)) {
			flag = true;
		}
		else {
			flag = false;
		}
		
		//5.返回数据到客户端
		//获取输出流对象,采用打印流(也可以用BufferedWriter)，将字节流s.getOutputStream()转换为字符流
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		
		if(flag) {
			pw.println("登录成功");
		}
		else {
			pw.println("登录失败");
		}
		
		//6.释放资源
		br.close();
		s.close();
		//ss.close();//可以不关闭
	}
}
