package system.bll;
import  system.bean.LoginBean;
import system.file.*;
public class LoginFile {
	LoginDao ld = new LoginDao();
	public boolean isLogin(LoginBean login) {
		boolean success = false;
		if(login != null) {
			login.setPwd(login.getPwd().trim());
			login.setUserName(login.getUserName().trim());
		}
		if(ld.loginDao(login)) {
			success = true;
		}
		return success;
	}
}
