public class test {
    public String ps;

    public static void main(String[] args) {
        Thread2 t1 = new Thread2("https://img1.doubanio.com/view/subject/l/public/s32279258.jpg", "1.jpg");
        Thread2 t2 = new Thread2(
                "https://img-blog.csdnimg.cn/20201210142514843.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NlcmVuZGlwaXR5X3hy,size_16,color_FFFFFF,t_70",
                "2.jpg");
        Thread2 t3 = new Thread2(
                "https://t11.baidu.com/it/u=3806721220,2562940989&fm=173&app=49&f=JPEG?w=524&h=662&s=765256205A34964F5EDB3F970300308F",
                "3.jpg");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("hhh");

    }
}