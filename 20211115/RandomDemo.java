import java.util.*;
public class RandomDemo{
	public static void main(String[] args) {
		Random r = new Random();
		for(int i = 0 ; i < 10 ; i++) {
			int n = r.nextInt(11);
			System.out.printf("第"+i+"个随机数:"+"%3d\n",n);
		}
	}
}