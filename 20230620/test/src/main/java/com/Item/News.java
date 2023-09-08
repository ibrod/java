package com.Item;

import java.sql.Date;

public class News {
    public int nid;
    public int ntid;
    public String ntitle;
    public String nauthor;
    public Date ncreateDate;
    public String npicPath;
    public String ncontent;
    public Date nmodifyDate;
    public String nsummary;

    public News() {
        nid = 0;
        ntid = 0;
        ntitle = "";
        nauthor = "";
        ncreateDate = null;
        npicPath = "";
        ncontent = "";
        nmodifyDate = null;
        nsummary = "";
    }
}
