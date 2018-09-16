package bull03.ServletDownload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Decoder.BASE64Encoder;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset='UTF-8'");
		// 1.���ղ���
		String filename = new String(request.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(filename);
		// 2.����ļ�����:
		// 2.1����Content-Typeͷ
		String type = this.getServletContext().getMimeType(filename);
		response.setHeader("Content-Type", type);
		// 2.3�����ļ���InputStream.
		String realPath = this.getServletContext().getRealPath("/downLoad/"+filename);
		
		// ��������������ʹ��������ļ�����������:
		String agent = request.getHeader("User-Agent");
		System.out.println(agent);
		if(agent.contains("Firefox")){
			filename = base64EncodeFileName(filename);
		}else{
			filename = URLEncoder.encode(filename,"UTF-8");
		}

		// 2.2����Content-Dispositionͷ
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		InputStream is = new FileInputStream(realPath);
		// ���response�������:
		OutputStream os = response.getOutputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while((len = is.read(b))!= -1){
			os.write(b, 0, len);
		}
		is.close();
	}
	
	//�����������ļ�����������
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
		return "=?UTF-8?B?"
		+ new String(base64Encoder.encode(fileName
		.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
		}
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
