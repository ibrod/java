import java.util.concurrent.*;

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("God bless you!");
        }
    }
}

class You implements Callable<Boolean> {

    @Override
    public Boolean call() {
        for (int i = 0; i < 365 * 100; i++) {
            System.out.println("Happy life!");
        }
        System.out.println("----------Goodbye world!----------");
        return true;
    }
}

class she implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 365 * 100; i++) {
            System.out.println("Happy life!");
        }
        System.out.println("----------Goodbye world!----------");
    }
}

public class Daemon_test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true);// 默认是false表示用户线程，正常的线程都是用户线程
        thread.start();
        // 上帝守护线程启动
        ExecutorService ser = Executors.newFixedThreadPool(1);
        // 一般的线程启动
        Future<Boolean> r = ser.submit(you);
        System.out.println(r.get());// get方法一般放在最后
        ser.shutdown();
    }
}
