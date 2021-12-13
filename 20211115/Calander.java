import java.text.SimpleDateFormat;
import java.util.*;
public class Calander {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DATE);
		System.out.println(year+"-"+(month+1)+"-"+day);
		long sum = 0l;
		SimpleDateFormat sdf = new SimpleDateFormat("本程序开始于：yyyy年MM月dd日 hh：mm：ss");
		Calendar current = Calendar.getInstance();
		Date d = current.getTime();
		long start = d.getTime();
		System.out.println("开始计算："+sdf.format(d));
		for(long i = 0 ; i <= 1000000000 ; i++) {
			sum += i;
		}
		long end = (Calendar.getInstance()).getTimeInMillis();
		long sec = end - start;
		System.out.println("程序历时"+sec+"毫秒");		
	}
}