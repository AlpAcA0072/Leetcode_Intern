package shangxuetang.video.old2019.Multithreading;

/**
 * 创建线程的第一种方式
 * <p>
 * 1. extends Thread + 重写 run
 * <p>
 * 2. 创建子类对象 + 调用start方法
 */
public class p196 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("new thread");
        }
    }

    public static void main(String[] args) {
        p196 newThread = new p196();
        // private native void start0();
        // 本地方法start0()会调用run()
        // 新线程 无序
        newThread.start();
        // 调用 有序
//        newThread.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread");
        }
    }
}
