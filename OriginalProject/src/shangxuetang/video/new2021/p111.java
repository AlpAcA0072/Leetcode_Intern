package shangxuetang.video.new2021;

public class p111 {
    public static void main(String[] args) {
         A a = new A() {
            @Override
            public void run() {
                System.out.println("AnonymousInnerClass.run");
            }
        };
        a.run();


        // implements实现
        AA aa = new AA();
        aa.run();
    }

    private void test(A a) {
        a.run();
    }
}

class AA implements A {
    @Override
    public void run() {
        System.out.println("AA.run");
    }
}

interface A {
    void run();
}