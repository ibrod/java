package system.file;

import system.bean.LoginBean;
import java.io.*;
import java.util.*;

public class Dao {
	public static void dao(String mch) {
		boolean b = false;
		try {

			FileHelper.setAddress("data.txt");
			BufferedReader br = FileHelper.getBufferedReader();
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] s = line.split(" ");
				if (s[0].equals(mch)) {
					System.out.println("查询成功:(输出格式:编号id+收支项目+收入或支出+金额+收支人+时间)");
					b = true;
					for (int i = 0; i < s.length; i++) {
						System.out.print(s[i]);
						System.out.print(" ");

					}
					break;
				}
			}
			if (!b)
				System.out.println("对不起，没有该条记录");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String flst() {
		String lst = null;
		try {
			FileHelper.setAddress("data.txt");
			BufferedReader br = FileHelper.getBufferedReader();
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] s = line.split(" ");
				lst = s[0];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lst;
	}
}
