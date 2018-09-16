package bull.utils;
/**
 * 随机获取序号
 */
import java.util.UUID;

public class UUIDUtils {
	public static String getUUID() {
		//生成的序号中有'-',去掉
		return UUID.randomUUID().toString().replace("-", "");
	}
}
