package shangxuetang.video.old2019.Multithreading;

/**
 * 守护线程为用户线程服务。
 * JVM不会等待守护线程执行完毕再停止。
 * 线程默认为用户线程。
 */
public class p210_DeamonTest {
    public static void main(String[] args) {
        Thread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        // JVM不会等待daemonThread的结束。
        daemonThread.start();

        new UserThread().start();
    }
}

class UserThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("UserThread runs...");
        }
        System.out.println("UserThread dead.");
    }
}

class DaemonThread extends Thread {
    // non-stop
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
                System.out.println("DaemonThread runs...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

