package shangxuetang.video.old2019.Multithreading;

/**
 * sleep模拟网络延迟，放大问题出现的可能性
 * <p>
 */
public class p205_Sleep implements Runnable {
    private int tickets = 100;

    public static void main(String[] args) {
        // 一份资源
        p199 newThread = new p199();
        // 多个代理
        new Thread(newThread, "用户1").start();
        new Thread(newThread, "用户2").start();
        new Thread(newThread, "用户3").start();
        // 存在tickets负数的情况
    }

    @Override
    public void run() {
        while (tickets > 0) {
            try {
                // sleep模拟网络延迟
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + tickets--);
        }
    }
}