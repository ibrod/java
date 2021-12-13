import java.util.*;
public class HashMapDemo {
	public static void main(String[] args) {
		HashMap h = new HashMap();
		h.put("张三", 30);
		h.put("李四", 50);
		h.put("王五", 60);
		h.put("赵六", 20);
		System.out.println("张三的成绩为："+h.get("张三"));
		if(h.isEmpty()){
			System.out.println("无对应关系");
		}else{
			System.out.println("有对应关系 ");
		}
		System.out.println(h.toString());
		h.remove("王五");
		System.out.println(h.toString());
		if(h.containsKey("王五")) {
			System.out.println("存在王五这个键");
		}else {
			System.out.println("不存在王五这个键");
		}
		if(h.containsValue(20)) {
			System.out.println("存在20这个值");
		}else {
			System.out.println("不存在20这个值");
		}
	}
}