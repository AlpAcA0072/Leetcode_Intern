package shangxuetang.video.old2019.Multithreading;

/**
 * Lambda表达式
 * <p>
 * 简化线程的使用（一般使用一次）
 * <p>
 * 外部类不使用，内部类不编译
 */
public class p202_LambdaThread {
    // 静态内部类
    static class Test implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("new thread");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Test()).start();

        // 局部内部类
        class Test2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("new thread");
                }
            }
        }
        new Thread(new Test2()).start();

        // 匿名内部类，借助接口/父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("new thread");
                }
            }
        }).start();
        // Lambda 参数 -> 实现
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("new thread");
            }
        }).start();
    }
}
