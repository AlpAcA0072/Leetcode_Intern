package shangxuetang.video.old2019.Multithreading;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDownloader {
    /**
     * 下载方法
     *
     * @param url  下载文件的url
     * @param name 本地文件名
     */
    public void download(String url, String name) {
        // Implemented: Download with url and name.
        String des = "OriginalProject/src/resource/";
        if (!name.contains(des)) {
            name = des + name;
        }
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (MalformedURLException e) {
            System.out.println("不合法的url");
        } catch (IOException e) {
            System.out.println("下载失败");
        }
    }
}
