import java.util.LinkedList;
public class list {
	public static void main(String[] args) {
	    LinkedList ll = new LinkedList(); 
	    for (int i = 1; i <= 10; i++) {
	      Double temp = new Double(Math.sqrt(i)); 
	      ll.add(temp);  
	    }
	    System.out.println("链表中的元素：");
	    for (int i = 0; i < ll.size(); i++) {
	      System.out.println(ll.get(i));
	    }
	    System.out.println("*********************************");
	    ll.removeFirst(); 
	    ll.removeLast();   
	    System.out.println("删除第一个元素和最后一个元素后的链表：");
	    for (int i = 0; i < ll.size(); i++) {
	      System.out.println(ll.get(i));
	    }
	}
}