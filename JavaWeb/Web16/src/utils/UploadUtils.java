package utils;
/**
 * UploadUtils.getPath(uuidFileName)��ȡ�����ļ���uploadFiles�����·����
 * @author 45��ը
 *
 */
public class UploadUtils {
	public static String getPath(String uuidFileName) {
		//Ψһ�ļ���.hashcode()
		int code1 = uuidFileName.hashCode();
		int d1 = code1 & 0xf; //���һ��Ŀ¼
		int code2 = code1 >>> 4; //������λ
		int d2 = code2 & 0xf; //��ö���Ŀ¼
		return "/"+d1+"/"+d2;
	}
}
