import java.text.ParseException;
import java.text.SimpleDateFormat;//格式化文本输出
import java.util.*;
public class Datef {
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat s2 = new SimpleDateFormat("这是一个中第w周，一年中第D天");
		System.out.println(s1.format(d));
		System.out.println(s2.format(d));
		String birthDay = "2012-03-15 09:30:00";
		Date birth = new Date();
		try {
			birth = s1.parse(birthDay);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(s1.format(birth));
	}
}