package shangxuetang.video.new2021;

public class p103_SuperMan implements Volant, Honest {
    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void help() {
        System.out.println("help");
    }

    // 直接从属于SuperMan，和Volant的同名方法无关系
    static int returnHeight() {
        return Volant.MAX_HEIGHT;
    }

    public static void main(String[] args) {
        Volant sm = new p103_SuperMan();
        sm.fly();
        Honest h = (Honest) sm;
        h.help();
        System.out.println(Volant.MAX_HEIGHT);
        System.out.println(p103_SuperMan.MAX_HEIGHT);
    }
}
