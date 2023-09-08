package com.Dao;
import com.Item.News;
public interface NewsSqlDao {
    public void showNews();
    public void showNews(int nid);
    public void addNews(News news);
    public void deleteNewsByNid(int nid);
    public void updateNewsByNid(News news);
}
