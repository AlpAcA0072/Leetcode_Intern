package shangxuetang.video.old2019.Multithreading;

import java.util.concurrent.*;

/**
 * 创建线程的方式三
 */
public class p200 implements Callable<Boolean> {
    private final String url;
    private final String name;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        p200 d1 = new p200("https://img2.imgtp.com/2024/05/31/LbPDDJ2T.jpg", "testDownloadPic1.jpg");
        p200 d2 = new p200("https://img2.imgtp.com/2024/05/31/LbPDDJ2T.jpg", "testDownloadPic2.jpg");
        p200 d3 = new p200("https://img2.imgtp.com/2024/05/31/LbPDDJ2T.jpg", "testDownloadPic3.jpg");

        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> result1 = service.submit(d1);
        Future<Boolean> result2 = service.submit(d2);
        Future<Boolean> result3 = service.submit(d3);
        //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println(r1 + " " + r2 + " " + r3);
        // 关闭服务
        service.shutdown();
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        return true;
    }

    public p200(String url, String name) {
        this.url = url;
        this.name = name;
    }
}
