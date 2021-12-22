package loginpro.file;

import loginpro.bean.LoginBean;
import java.io.*;
import java.util.*;

public class LoginDao {
	// 调用FileHelper类的方法，实现文件的读写
	public boolean loginDao(LoginBean login) {
		boolean b = false;
		try {
			FileHelper.setAddress("login.txt");
			BufferedReader br = FileHelper.getBufferedReader();
			String line = null;
			while ((line = br.readLine()) != null) {//进行暴力匹配操作
				String[] s = line.split(" ");
				if (s[0].equals(login.getUserName()) && s[1].equals(login.getPwd())) {
					b = true;
					break;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}
}
