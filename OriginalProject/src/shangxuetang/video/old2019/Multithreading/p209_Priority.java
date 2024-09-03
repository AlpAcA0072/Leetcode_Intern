package shangxuetang.video.old2019.Multithreading;

/**
 * 线程的优先级
 * <p>
 * NORM_PRIORITY = 5 (默认优先级)
 * <p>
 * MIN_PRIORITY = 1 (最小)
 * <p>
 * MAX_PRIORITY = 10 (最大)
 */
public class p209_Priority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());

        MyPriority mp = new MyPriority();
        new Thread(mp, "t1").start();

        // 必须在启动前设置优先级
        // 并不是优先级高的一定优先运行。而是标志着优先获得cpu调度的概率更高。
        Thread t2 = new Thread(mp, "t2");
        t2.setPriority(Thread.MAX_PRIORITY);

        Thread t3 = new Thread(mp, "t3");
        t3.setPriority(Thread.MAX_PRIORITY);

        Thread t4 = new Thread(mp, "t4");
        t4.setPriority(Thread.MAX_PRIORITY);

        Thread t5 = new Thread(mp, "t5");
        t5.setPriority(Thread.MIN_PRIORITY);

        Thread t6 = new Thread(mp, "t6");
        t6.setPriority(Thread.MIN_PRIORITY);

        Thread t7 = new Thread(mp, "t7");
        t7.setPriority(Thread.MIN_PRIORITY);

        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority());
    }
}