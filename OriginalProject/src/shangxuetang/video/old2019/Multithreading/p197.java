package shangxuetang.video.old2019.Multithreading;

/**
 * 多线程下载图片
 */
public class p197 extends Thread {
    private final String url;
    private final String name;

    @Override
    public void run() {
        Downloader.download(url, name);
    }

    public p197(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) {
        p197 thread1 = new p197("url1", "name1");
        p197 thread2 = new p197("url2", "name2");
        p197 thread3 = new p197("url3", "name3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Downloader {
    /**
     * 下载方法
     *
     * @param url  下载文件的url
     * @param name 本地文件名
     */
    public static void download(String url, String name) {
        // TODO: Download with url and name.
    }
}