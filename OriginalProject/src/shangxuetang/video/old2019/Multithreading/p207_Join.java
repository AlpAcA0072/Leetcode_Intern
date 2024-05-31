package shangxuetang.video.old2019.Multithreading;

/**
 * join合并线程，插队
 */
public class p207_Join {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Lambda: " + i);
            }
        });
        t.start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                // 插队 main被阻塞了
                t.join();
            }
            System.out.println("main" + i);
        }
    }
}
