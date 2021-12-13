import java.util.*;
public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		System.out.println(a.size());
		a.add(23);
		a.add("你好");
		System.out.println(a.size());
		ArrayList a1 = new ArrayList(a);
		System.out.println(a1);
		a1.add(1,8.98);
		System.out.println(a1);
		a1.addAll(2,a);
		System.out.println(a1);
		a1.remove(3);
		System.out.println(a1);
		a1.remove(new Integer(23));
		System.out.println(a1);
		a1.set(0, "我在126");
		System.out.println(a1);
		for(Object each:a1) {
			System.out.printf(each.toString()+"\t");
		}
		System.out.println();
		for(int i = 0 ; i < a1.size() ; i++) {
			System.out.println("第"+i+"个元素为"+a1.get(i));
		}
		if(a1.isEmpty()) {
			System.out.println("为空");
		}else {
			System.out.println("不为空");
			if(a1.contains("你好")) {
				System.out.println("包含\"你好\"");
				int index = a1.indexOf("你好");
				System.out.println("在第"+index+"个位置");
			}else {
				System.out.println("不包含\"你好\"");
			}
		}
		ArrayList a2 = new ArrayList();
		a2.add("hello");
		a2.add("Eho");
		a2.add("John");
		a2.add("how are you");
		Collections.sort(a2);
		System.out.println(a2.toString());
		Collections.reverse(a2);
		System.out.println(a2.toString());
	}
}

