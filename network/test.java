import java.net.InetAddress;

public class test {
    public static void main(String[] args) {
        try {
            // 查询本机地址
            final InetAddress inetAddress = InetAddress.getLocalHost();
            // 获取本机名
            final String hostName = inetAddress.getHostName();
            // 获取本机IP
            final String address = inetAddress.getHostAddress();
            System.out.println("主机名：" + hostName + "，IP地址：" + address);

            // 查询网站ip地址
            final InetAddress a = InetAddress.getByName("www.baidu.com");
            // 不解析查询结果
            System.out.println("第1次查询结果：" + a);
            System.out.println("第1次查询结果：" + "地址：" + a.getHostAddress() + ",主机名：" + a.getHostName());

            // 常用方法
            System.out.println("查询版本号：" + a.getAddress());
            System.out.println("主机名称：" + a.getHostName());
            System.out.println("ip长度：" + a.getAddress().length);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
