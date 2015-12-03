package po;

public class UserInfoPO {
	private String username;// 用户姓名
	private String password;// 密码
	private String userID;// 账户ID
	private String position;// 职位

	public UserInfoPO(String userID, String p, String username, String pos) {
		this.username = username;
		this.password = p;
		this.userID = userID;
		this.position = pos;

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getUserID() {
		return userID;
	}

	public String getPosition() {
		return position;
	}
}
