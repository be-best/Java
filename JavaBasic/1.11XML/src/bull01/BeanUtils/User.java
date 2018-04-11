package bull01.BeanUtils;

import java.util.Arrays;

public class User implements java.io.Serializable {
	private String userName;
	private String userId;
	private String userPasswd;
	private String userHobby[];
	private int userAge;
	
	public User() {
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	public String[] getUserHobby() {
		return userHobby;
	}
	public void setUserHobby(String[] userHobby) {
		this.userHobby = userHobby;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId
				+ ", userPasswd=" + userPasswd + ", userHobby="
				+ Arrays.toString(userHobby) + ", userAge=" + userAge + "]";
	}
	
	
	
	
	
}
