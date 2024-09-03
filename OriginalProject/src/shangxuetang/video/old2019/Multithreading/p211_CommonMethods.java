package shangxuetang.video.old2019.Multithreading;

/**
 * 常用方法
 */
public class p211_CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        // 设置名称：真实角色 + 代理角色
        MyThread myThread = new MyThread("MyThread");
        Thread t = new Thread(myThread);
        t.setName("Proxy Thread");
        t.start();

        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}

class MyThread implements Runnable {
    private final String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " --- " + name);
    }
}