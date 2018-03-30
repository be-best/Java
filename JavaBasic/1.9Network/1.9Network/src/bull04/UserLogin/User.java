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

	//��дequals����
	@Override
	public boolean equals(Object obj) {
		//���Ч��
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//��ߴ��뽡׳��
		if (getClass() != obj.getClass())
			return false;
		//����ת��
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
