package model;

public class User {
	private int userId;
	private String userName;
	private String userBirthDate;
	private String userBirthTime;
	private String userDistrict;
	public User(String userName, String userBirthDate, String userBirthTime, String userDistrict) {
		super();
		//this.userId = userId;
		this.userName = userName;
		this.userBirthDate = userBirthDate;
		this.userBirthTime = userBirthTime;
		this.userDistrict = userDistrict;
	}
	public User() {
    }
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirthDate() {
		return userBirthDate;
	}
	public void setUserBirthDate(String userBirthDate) {
		this.userBirthDate = userBirthDate;
	}
	public String getUserBirthTime() {
		return userBirthTime;
	}
	public void setUserBirthTime(String userBirthTime) {
		this.userBirthTime = userBirthTime;
	}
	public String getUserDistrict() {
		return userDistrict;
	}
	public void setUserDistrict(String userDistrict) {
		this.userDistrict = userDistrict;
	}
	
	

}
