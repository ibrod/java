package system.ui;
import system.bean.Bean;
import system.bll.*;
import system.file.Dao;
import system.file.*;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Process {
	public static void main(String[] args) {
		//FileHelper.wt("sadasd");
		Scanner in = new Scanner(System.in);
		System.out.println("欢迎来到该系统,输入1增加信息，输入2查询信息");
		System.out.println("请输入:");
		String mode = in.next();
		int idx=3;
		if(mode.equals("1")){
			System.out.println("请输入收支项目:");
			String item = in.next();
			System.out.println("请输入金额:");
			String money = in.next();
			System.out.println("请输入收支人:");
			String name = in.next();
			System.out.println("请输入时间:");
			String time = in.next();
			System.out.println("请输入收支类型(收入1或支出0):");
			String type = in.next();
			//int num=Integer.parseInt(Dao.flst())+1;
			Bean lb = new Bean(String.valueOf(idx++),item,money,name,time,type);
			FileHelper.wt(lb);
		}else if(mode.equals("2")){
			System.out.println("请输入您要查询的编号id:");
			String id = in.next();
			Dao.dao(id);
		}else{
			System.out.println("输入错误，请重新输入:");
			main(args);
			return;
		}

		
	}
}
