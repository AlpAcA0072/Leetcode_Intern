package shangxuetang.video.old2019;

public class p76 {
}

class Vichcle {

}

class Horse extends Vichcle {

}

class TestFather {
    protected Vichcle returnVichcle() {
        return new Vichcle();
    }
}

class TestSon extends TestFather {
//    private Vichcle returnVichcle() {
//        return new Vichcle();
//    }

//    public Object returnVichcle() {
//        return new Object();
//    }

    public Horse returnVichcle() {
        return new Horse();
    }
}