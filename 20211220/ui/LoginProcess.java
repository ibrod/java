package loginpro.ui;

import loginpro.bean.LoginBean;
import loginpro.bll.*;
import java.util.Scanner;

public class LoginProcess {
	// 调用LoginFile类的方法，实现登录
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("欢迎登录本系统,进行操作");
		System.out.println("请输入用户名:");
		String uname = in.next();
		System.out.println("请输入密码:");
		String pwd = in.next();
		LoginBean login = new LoginBean(uname, pwd);
		LoginFile lf = new LoginFile();
		if (lf.isLogin(login))
			System.out.println("登陆成功");
		else
			System.out.println("登录失败");
	}
}
