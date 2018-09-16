package utils;

import java.util.UUID;

public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
		
	}
/**
 * ��ȡ����ļ���	
 * @param fileName
 * @return
 */
	public static String getUUIDFilename(String fileName) {
		return UUID.randomUUID().toString().replace("-", "")+"_"+fileName;
	}
}
