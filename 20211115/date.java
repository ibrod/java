import java.util.*;
public class date {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println("年"+d.getYear());
		System.out.println("月"+d.getMonth());
		System.out.println("日"+d.getDate());;
		System.out.println("时"+d.getHours());;
		System.out.println("分"+d.getMinutes());;
		System.out.println("秒"+d.getSeconds());
		Date d1 = new Date(2017,3,15);
		System.out.println("年"+d1.getYear());
		System.out.println("月"+d1.getMonth());
		System.out.println("日"+d1.getDate());;
		System.out.println("时"+d1.getHours());;
		System.out.println("分"+d1.getMinutes());
		System.out.println("秒"+d1.getSeconds());
		if(d.after(d1)) {
			System.out.println("已出生...");
		}else if(d.before(d1)) {
			System.out.println("未出生...");
		}
		System.out.println(d1.toString());
	    String strDate = d1.toString();
	    String strTime = strDate.substring(11, (strDate.length() - 4));
	    System.out.println(strTime);
	    strTime = strTime.substring(0, 8);
	    System.out.println(strTime);
	}
}