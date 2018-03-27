package bull179.Recursive;
/*
 * µÝ¹é
 * Çó5µÄ½×²ã
 */
public class RecursiveDemo1 {
	public static void main(String[] args) {
		int j = recursive(5);
		System.out.println(j);
	}
	public static int recursive(int x) {
		int result;
		if(x == 1) {
			return 1;
		}
		else {
			result = x*recursive(x-1);
		}
		return result;
	}
}
