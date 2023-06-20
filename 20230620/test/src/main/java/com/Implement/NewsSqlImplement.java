package com.Implement;


import java.sql.PreparedStatement;

import com.Dao.NewsSqlDao;
import com.Item.News;

public class NewsSqlImplement extends SqlConnectionParent implements NewsSqlDao {
    // 在父类中已经定义并实现了Connection conn，现在直接使用即可
    @Override
    public void showNews() {
        // 获取操作数据库的对象
        try {
            PreparedStatement pstm=conn.prepareStatement(password);
            // 创建sql语句
            String sql = "select * from news";
            // 执行sql语句
            java.sql.Statement stmt = conn.createStatement();
            // 获取结果集
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            // 遍历结果集
            while (rs.next()) {
                System.out.println(rs.getString("ntitle"));
                System.out.println(rs.getString("nauthor"));
                System.out.println(rs.getString("ncreateDate"));
                System.out.println(rs.getString("npicPath"));
                System.out.println(rs.getString("ncontent"));
                System.out.println(rs.getString("nmodifyDate"));
                System.out.println(rs.getString("nsummary"));
            }
            // 关闭资源
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addNews(News news) {
        try {
            // 创建sql语句
            String sql = "insert into news(ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) values(?,?,?,?,?,?,?,?)";
            // 执行sql语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, news.ntid);
            pstmt.setString(2, news.ntitle);
            pstmt.setString(3, news.nauthor);
            pstmt.setDate(4, news.ncreateDate);
            pstmt.setString(5, news.npicPath);
            pstmt.setString(6, news.ncontent);
            pstmt.setDate(7, news.nmodifyDate);
            pstmt.setString(8, news.nsummary);
            pstmt.executeUpdate();
            // 关闭资源
            pstmt.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    @Override
    public void deleteNewsByNid(int nid) {
       try {
        // 创建sql语句
        String sql = "delete from news where nid=?";
        // 执行sql语句
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, nid);
        pstmt.executeUpdate();
        // 关闭资源
        pstmt.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void updateNewsByNid(News news) {
        try {
            // 创建sql语句
            String sql = "update news set ntid=?,ntitle=?,nauthor=?,ncreateDate=?,npicPath=?,ncontent=?,nmodifyDate=?,nsummary=? where nid=?";
            // 执行sql语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, news.ntid);
            pstmt.setString(2, news.ntitle);
            pstmt.setString(3, news.nauthor);
            pstmt.setDate(4, news.ncreateDate);
            pstmt.setString(5, news.npicPath);
            pstmt.setString(6, news.ncontent);
            pstmt.setDate(7, news.nmodifyDate);
            pstmt.setString(8, news.nsummary);
            pstmt.setInt(9, news.nid);
            pstmt.executeUpdate();
            // 关闭资源
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showNews(int nid) {
       try {
        // 创建sql语句
        String sql = "select * from news where nid=?";
        // 执行sql语句
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, nid);
        // 获取结果集
        java.sql.ResultSet rs = pstmt.executeQuery();
        // 遍历结果集
        while (rs.next()) {
            System.out.println(rs.getString("ntitle"));
            System.out.println(rs.getString("nauthor"));
            System.out.println(rs.getString("ncreateDate"));
            System.out.println(rs.getString("npicPath"));
            System.out.println(rs.getString("ncontent"));
            System.out.println(rs.getString("nmodifyDate"));
            System.out.println(rs.getString("nsummary"));
        }
        // 关闭资源
        rs.close();
        pstmt.close();
       } catch (Exception e) {
        e.printStackTrace();
       }
    }

 
}
