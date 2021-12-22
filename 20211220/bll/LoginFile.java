package loginpro.bll;

import loginpro.bean.LoginBean;
import loginpro.file.*;

public class LoginFile {
	LoginDao ld = new LoginDao();

	public boolean isLogin(LoginBean login) {
		boolean success = false;
		if (login != null) {
			login.setPwd(login.getPwd().trim());
			login.setUserName(login.getUserName().trim());
		} // 去除空格
		if (ld.loginDao(login)) {
			success = true;
		} // 进行数据库(实际上是文件)查询
		return success;
	}
}
