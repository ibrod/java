import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Thread2 extends Thread {
    private String url;
    private String name;

    public Thread2(String url,String name){
        this.url=url;
        this.name=name;
    }

    public void run(){
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println(name+"下载完成");
    }
}

class WebDownloader{
    public void downloader(String url,String name){
        try{
        FileUtils.copyURLToFile(new URL(url), new File(name));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}