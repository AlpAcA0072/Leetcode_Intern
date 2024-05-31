package shangxuetang.video.old2019.Multithreading;

/**
 * yield礼让线程，暂停线程。
 * 直接进入就绪状态（不是阻塞状态），等待cpu调度。
 */
public class p206_Yield {
    public static void main(String[] args) {
        Class a = new Class();
        new Thread(a, "a").start();
        new Thread(a, "b").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 20 == 0) {
                    Thread.yield();
                }
                System.out.println("Lambda1: " + i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Lambda2: " + i);
            }
        }).start();
    }
}

class Class implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " end");
    }
}