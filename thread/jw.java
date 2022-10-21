public class jw implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("t0")) {
                Thread.yield();// 让出cpu
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        Thread t0 = new Thread(new jw(), "t0");
        Thread t1 = new Thread(new jw(), "t1");
        Thread t2 = new Thread(new jw(), "t2");
        t0.start();
        t1.start();
        t2.start();
        for (int i = 1; i <= 100; i++) {
            if (i == 90) {
                t1.join();// t1线程加入到主线程中，主线程等待t1线程执行完毕后再执行
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        while (true) {
            if (t1.isAlive() || t2.isAlive()) {
                continue;
            } else {
                System.out.println("hhh");
                break;
            }
        }
    }

}
