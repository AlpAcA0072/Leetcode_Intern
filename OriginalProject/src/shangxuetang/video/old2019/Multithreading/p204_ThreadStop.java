package shangxuetang.video.old2019.Multithreading;

/**
 * 终止线程
 * <p>
 * 1. 线程正常执行完毕
 * 2. 外部干涉
 * </p>
 * 不要使用 stop destroy方法
 */
public class p204_ThreadStop implements Runnable {
    // 1. 加入标识，标记线程体是否继续运行
    private boolean flag = true;
    private final String name;

    public static void main(String[] args) {
        p204_ThreadStop threadStop = new p204_ThreadStop("threadStop");
        new Thread(threadStop).start();

        for (int i = 0; i < 100; i++) {
            if (i == 99) {
                threadStop.terminate();
                System.out.println("stop");
            }
            System.out.println("main thread: " + i);
        }
    }

    public p204_ThreadStop(String name) {
        this.name = name;
    }

    // 2. 对外提供方法改变标识
    public void terminate() {
        this.flag = false;
    }

    @Override
    public void run() {
        int i = 0;
        // 3. 关联标识，true运行，false停止
        while (flag) {
            System.out.println(name + i++);
        }
    }
}
