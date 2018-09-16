package utils;
/**
 * UploadUtils.getPath(uuidFileName)获取的是文件在uploadFiles里面的路径。
 * @author 45度炸
 *
 */
public class UploadUtils {
	public static String getPath(String uuidFileName) {
		//唯一文件名.hashcode()
		int code1 = uuidFileName.hashCode();
		int d1 = code1 & 0xf; //获得一级目录
		int code2 = code1 >>> 4; //右移四位
		int d2 = code2 & 0xf; //获得二级目录
		return "/"+d1+"/"+d2;
	}
}
