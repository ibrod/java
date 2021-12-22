package loginpro.bean;

public class LoginBean {
	private String userName;
	private String pwd;

	public LoginBean() {
		super();
	}

	public LoginBean(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}

	// getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
