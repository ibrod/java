package Test;

import java.util.*;

class Race implements Runnable {
	private static String winner = null;

	public void run() {
		try {
			for (int i = 1; i <= 100; i++) {
				if (winner != null)
					return;
				System.out.println(Thread.currentThread().getName() + "�Ѿ�����" + i + "��");
				if (i == 50 && Thread.currentThread().getName().equals("rabbit")) {
					Thread.sleep(20);
				} else {
					Thread.sleep(10);
				}
			}
			if (winner == null) {
				winner = Thread.currentThread().getName();
				System.out.println(Thread.currentThread().getName() + "��ʤ");
			}
		} catch (Exception e) {
		}
	}
}

public class Thread4 {
	public static void main(String[] args) {
		Race race = new Race();
		new Thread(race, "rabbit").start();
		new Thread(race, "tortoise").start();
		new Thread(race, "big snail").start();
	}
}