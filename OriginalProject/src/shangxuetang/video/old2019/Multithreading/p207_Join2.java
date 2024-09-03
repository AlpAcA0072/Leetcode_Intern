package shangxuetang.video.old2019.Multithreading;

/**
 * t.join()
 * 等待t线程终止（阻塞其他线程）
 */
public class p207_Join2 {
    public static void main(String[] args) {
        Father father = new Father();
        father.start();
    }
}

class Father extends Thread {
    @Override
    public void run() {
        System.out.println("准备做饭....");
        System.out.println("让儿子买材料....");
        Thread t = new Thread(new Son());
        t.start();
        try {
            // Father被阻塞，Son执行完Father才能继续执行
            t.join();
            // t.join(millis)的含义
            // t.join(millis) 的含义是让当前线程等待线程 t 结束执行，但最多等待 millis 毫秒。
            // 最大容忍被阻塞时间
            t.join(1000);
            System.out.println("接过材料，开始做饭");
        } catch (InterruptedException e) {
            System.out.println("儿子跑丢了？？？");
            throw new RuntimeException(e);
        }
    }
}

class Son extends Thread {
    @Override
    public void run() {
        System.out.println("拿上老爸的钱");
        System.out.println("玩去了。。。");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("玩了" + i + "秒");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("赶紧去买材料");
        System.out.println("回家了");
    }
}