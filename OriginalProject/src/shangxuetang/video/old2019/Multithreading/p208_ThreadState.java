package shangxuetang.video.old2019.Multithreading;

import java.lang.Thread;

public class p208_ThreadState {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("new Thread t");
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Thread t");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        });
        Thread.State state = t.getState();
        // NEW
        System.out.println(state);

        t.start();
        state = t.getState();
        // RUNNABLE
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
            state = t.getState();
            // TIMED_WAITING
            System.out.println(state);
        }

        // TERMINATED
        state = t.getState();
        System.out.println(state);
    }
}
