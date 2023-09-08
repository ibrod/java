package com.sqltest;
import com.Dao.NewsSqlDao;
import com.Implement.NewsSqlImplement;
import com.Item.News;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        NewsSqlDao newsSqlDao = new NewsSqlImplement();
        // newsSqlDao.showNews(50);


        // newsSqlDao.showNews(1);

        News news = new News();
        news.ntid = 1;
        news.nauthor = "hhhhhhhhhhhhh";
        news.ncontent = "test";
        news.ncreateDate = new java.sql.Date(new java.util.Date().getTime());
        news.nmodifyDate = new java.sql.Date(new java.util.Date().getTime());
        news.npicPath = "test";
        news.nsummary = "test";
        news.ntitle = "test";
        // newsSqlDao.addNews(news);

        news.nid = 52;
        newsSqlDao.updateNewsByNid(news);

        // newsSqlDao.deleteNewsByNid(26257);



        // newsSqlDao.showNews(1);

        
    }
}
