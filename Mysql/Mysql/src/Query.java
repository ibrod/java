import java.sql.*;

public class Query {
    public static void main(String[] args) throws Exception{
        // 1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 新版本的加载方式
        } catch (ClassNotFoundException e) {
            Class.forName("com.mysql.jdbc.Driver");// 旧版本的加载方式
        }
        // 2.获取连接
        String url ="jdbc:mysql://ag.thod.top:3306/java_test?useServerPrepStmts=true";//开启预编译
        String user = "java_test";
        String password = "Hnist_jk20_2bj";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 3.定义sql
        String sql = "select * from act";

        // 4.获取执行sql的对象
        Statement stmt = conn.createStatement();

        // 5.执行sql
        ResultSet rs = stmt.executeQuery(sql);// 返回结果集

        // 6.处理结果
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString(2);
            int money=rs.getInt(3);
            String note=rs.getString("note");
            int another_values = rs.getInt(5);
            System.out.println(id+"---"+name+"---"+money+"---"+note+"---"+another_values);
        }

        // 7.释放资源
        rs.close();
        stmt.close();


        //防止sql注入
        System.out.println("--------------------------------------------------------");
        sql="select * from act where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 1);

        rs = pstmt.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int money=rs.getInt(3);
            String note=rs.getString(4);
            int another_values = rs.getInt(5);
            System.out.println(id+"---"+name+"---"+money+"---"+note+"---"+another_values);
        }



    }
}
