package bull06.XMLTest;

public class User {
	private String uid;
	private String userName;
	private String userPasswd;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", userPasswd="
				+ userPasswd + "]";
	}
	
	
}
