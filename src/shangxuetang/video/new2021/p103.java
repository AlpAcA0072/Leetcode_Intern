package shangxuetang.video.new2021;

interface Volant {
    /*public static final*/ int MAX_HEIGHT = 100;

    /*public abstract*/ void stop();

    void fly();

    static int returnHeight() {
        return MAX_HEIGHT;
    }
}

interface Honest {
    void help();
}