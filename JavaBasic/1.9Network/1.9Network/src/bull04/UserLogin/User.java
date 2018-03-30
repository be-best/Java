package bull04.UserLogin;

public class User {
	private String userName;
	private String userPasswd;
	
	public User() {
		
	}
	
	public User(String userName,String userPasswd) {
		this.userName = userName;
		this.userPasswd = userPasswd;
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

	//重写equals方法
	@Override
	public boolean equals(Object obj) {
		//提高效率
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//提高代码健壮性
		if (getClass() != obj.getClass())
			return false;
		//向下转型
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPasswd == null) {
			if (other.userPasswd != null)
				return false;
		} else if (!userPasswd.equals(other.userPasswd))
			return false;
		return true;
	}
	
	
	
}
