import java.util.*;
public class vc {
	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("容量为："+v.capacity());
		System.out.println("长度为："+v.size());
		if(v.add(34)) {
			System.out.println("添加成功！");
		}else {
			System.out.println("添加失败！");
		}
		System.out.println("长度为："+v.size());
		v.add(45);
		v.add(67);
		v.add(4);
		v.add(95);
		v.add(976);
		Collections.sort(v);
		System.out.println(v.toString());
	}
}