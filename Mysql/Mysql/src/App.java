import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 新版本的加载方式
        } catch (ClassNotFoundException e) {
            Class.forName("com.mysql.jdbc.Driver");// 旧版本的加载方式
        }
        // 2.获取连接
        String url = "jdbc:mysql://ag.thod.top:3306/java_test";
        String user = "java_test";
        String password = "Hnist_jk20_2bj";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 3.定义sql
        String sql1 = "update act set another_values=another_values+1 where id = 1";
        String sql2 = "insert into act(name,money,another_values) values ";
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        
        // 随机生成数据
        for (int i = 1; i <= 5; i++) {
            sql2 += "('";
            for (int j = 0; j < 5; j++) {
                sql2 += s.charAt((int) (Math.random() * 52));
            }
            sql2 += "',";
            sql2 += (int) (Math.random() * 100000);
            sql2 += ",";
            sql2 += (int) (Math.random() * 1000);
            if (i == 5) {
                sql2 += ");";
            } else {
                sql2 += "),";
            }
        }
       // System.out.println(sql2);
        // 4.获取执行sql的对象
        Statement stmt = conn.createStatement();

        try {
            // 开启事务
            conn.setAutoCommit(false);// 关闭自动提交事务,要寄就一起寄

            // 5.执行sql
            int count = stmt.executeUpdate(sql1);// 影响的行数

            // 6.处理结果
            System.out.println(count);

            // 5.执行sql
            count = stmt.executeUpdate(sql2);
            // 6.处理结果
            System.out.println(count);
            // 提交事务
            conn.commit();// 关闭自动提交事务,要寄就一起寄

        } catch (Exception e) {
            // 回滚事务
            conn.rollback();
            e.printStackTrace();
        }
        // 7.释放资源
        stmt.close();
        conn.close();
    }
}
