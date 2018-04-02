package bull07.domain;
/*
 * ¥¥Ω®≤‚ ‘JavaBean
 */
public class User implements java.io.Serializable {
	private String userName;
	private String userPasswd;
	private String userId;
	
	public User() {
		
	}
	
	public User(String userName,String userPasswd,String userId) {
		this.userName = userName;
		this.userPasswd = userPasswd;
		this.userId = userId;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPasswd=" + userPasswd
				+ ", userId=" + userId + "]";
	}
	
	
}
