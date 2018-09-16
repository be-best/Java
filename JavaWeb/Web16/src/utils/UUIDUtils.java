package utils;

import java.util.UUID;

public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
		
	}
/**
 * 获取随机文件名	
 * @param fileName
 * @return
 */
	public static String getUUIDFilename(String fileName) {
		return UUID.randomUUID().toString().replace("-", "")+"_"+fileName;
	}
}
