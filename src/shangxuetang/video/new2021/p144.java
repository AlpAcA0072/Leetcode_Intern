package shangxuetang.video.new2021;

public class p144 {
    public static void main(String[] args) {
        try {
            p144 p = new p144();
            p.findFive();
        } catch (TestException e) {
            throw new RuntimeException(e);
        }
    }

    void findFive() throws TestException {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                throw new TestException("This is 5");
            }
        }
    }
}

class TestException extends Exception {
    public TestException() {

    }

    public TestException(String message) {
        super(message);
    }
}