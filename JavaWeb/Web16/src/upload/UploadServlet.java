package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import utils.UUIDUtils;
import utils.UploadUtils;

@MultipartConfig
public class UploadServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		//���ղ���
		//�ļ�����
		String filedesc = request.getParameter("filedesc");
		System.out.println("�ļ�������"+filedesc);
		//�����ļ�
		Part part = request.getPart("uploadfile");
		
		long fileSize = part.getSize();//�ļ���С
		String inputName = part.getName();//input�е�name��������
		System.out.println("�ļ���С��"+fileSize);
		System.out.println("input�е�name�������ƣ�"+inputName);
		
		//����ϴ����ļ�����
		String header = part.getHeader("Content-Disposition");
		//����f��ĸ���ڵ�λ��
		int idx = header.lastIndexOf("filename=\"");
		//filename="xxx.xxxx";xxx.xxx��λ����idx+10~header.length()-1;
		String fileName = header.substring(idx+10, header.length()-1);
		System.out.println("�ļ�����"+fileName);
		
		//����ļ�����
		InputStream is = part.getInputStream();
		
		//����ļ��ϴ�λ��uploadFiles��·��:xxx/xxx/uploadFiles
		String path = this.getServletContext().getRealPath("/uploadFiles");
		
		//���Ψһ�ļ��������ظ�
		String uuidFileName = UUIDUtils.getUUIDFilename(fileName);
		//path��uploadFiles��·����UploadUtils.getPath(uuidFileName)��ȡ�����ļ���uploadFiles�����·����
		String realPath = path + UploadUtils.getPath(uuidFileName);
		System.out.println("·����"+realPath);
		//new File(String pathname):ͨ����������·�����ַ���ת��Ϊ����·�����������µ� Fileʵ��
		File file = new File(realPath);
		//���file������,�����·���´����ļ�
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//��realPath�´�������ΪuuidFileName���ļ���
		OutputStream os = new FileOutputStream(realPath+"/"+uuidFileName);
		byte[] b = new byte[1024];
		int len = 0;
		//read:����������ȡ���ݵ���һ���ֽڡ� ֵ�ֽڱ�������Ϊint��Χ0��255 �� ���û���ֽڿ��ã���Ϊ�Ѿ���������ĩβ���򷵻�ֵ-1 ��
		while((len = is.read()) != -1) {
			os.write(b, 0, len);
		}
		os.close();
		
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
