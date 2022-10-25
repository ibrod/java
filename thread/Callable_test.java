import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class Callable_test implements Callable<String> {
    private String url;
    private String name;

    public Callable_test(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        WebDownloader wd = new WebDownloader();
        wd.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return name;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建执行对象
        Callable_test t1 = new Callable_test(
                "http://thod.top/public/upload/517/5368c1aa99c37b029d000001/images/logo/f53ba7496861b6da2f2d0fbb2e6479a4.jpg",
                "1.jpg");
        Callable_test t2 = new Callable_test(
                "https://img-blog.csdnimg.cn/20201210142514843.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NlcmVuZGlwaXR5X3hy,size_16,color_FFFFFF,t_70",
                "2.jpg");
        Callable_test t3 = new Callable_test(
                "https://t11.baidu.com/it/u=3806721220,2562940989&fm=173&app=49&f=JPEG?w=524&h=662&s=765256205A34964F5EDB3F970300308F",
                "3.jpg");
        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        System.out.println("---------------");
        Future<String> r1 = ser.submit(t1);
        Future<String> r2 = ser.submit(t2);
        Future<String> r3 = ser.submit(t3);
        // 获取结果
        String s1 = r1.get();// get会阻塞主线程，直到线程执行完毕
        String s2 = r2.get();
        String s3 = r3.get();
        System.out.println("---------------");
        // 关闭服务
        ser.shutdownNow();
        // System.out.println(s1 + " " + s2 + " " + s3);
    }
}
