package bull.utils;
/**
 * �����ȡ���
 */
import java.util.UUID;

public class UUIDUtils {
	public static String getUUID() {
		//���ɵ��������'-',ȥ��
		return UUID.randomUUID().toString().replace("-", "");
	}
}
