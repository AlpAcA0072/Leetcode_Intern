package shangxuetang.video.old2019.Multithreading;

/**
 * 创建线程方式二
 * <p>
 * 1. 创建：implements Runnable + 重写run
 * <p>
 * 2. 启动：创建实现类对象 + Thread对象 + start
 * <p>
 * 推荐，避免单继承的局限性，优先使用接口。
 * 方便共享资源。
 */
public class p198 implements Runnable {
    public static void main(String[] args) {
        // 实现类对象
        p198 newThread = new p198();
        // 代理类对象
        Thread t = new Thread(newThread);
        // 启动
        t.start();

        // 如果只用一次，也可以用一行调用
        new Thread(new p198()).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("Main thread");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("new thread");
        }
    }
}
