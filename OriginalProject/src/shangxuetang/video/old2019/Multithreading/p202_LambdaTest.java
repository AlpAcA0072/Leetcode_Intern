package shangxuetang.video.old2019.Multithreading;

public class p202_LambdaTest {
    static class Impls3 implements LambdaTest {
        @Override
        public void lambda() {
            System.out.println("Impls2");
        }
    }

    public static void main(String[] args) {
        LambdaTest impls = new Impls();
        impls.lambda();

        class Impls2 implements LambdaTest {
            @Override
            public void lambda() {
                System.out.println("Impls2");
            }
        }

        LambdaTest impls2 = new Impls2();
        impls2.lambda();

        LambdaTest impls3 = new Impls3();
        impls3.lambda();

        // Lambda
        LambdaTest impls4 = () -> System.out.println("Impls4");
        impls4.lambda();

        LambdaTest2 impls5 = System.out::println;
        impls5.lambda(5);

        LambdaTest2 impls6 = a -> System.out.println("Lambda" + a);
        impls6.lambda(6);

        LambdaTest3 impls7 = (i1, i2) -> {
            System.out.println("impls7 " + i1 + " " + i2);
            return i1 + i2;
        };
        int result = impls7.lambda(3, 4);
        System.out.println(result);

        LambdaTest3 impls8 = (i1, i2) -> i1 + i2;
        int result8 = impls8.lambda(4, 4);
        System.out.println(result8);

        LambdaTest3 impls9 = Integer::sum;
        int result9 = impls9.lambda(5, 4);
        System.out.println(result9);
    }
}

interface LambdaTest {
    void lambda();
}

interface LambdaTest2 {
    void lambda(int integer);
}

interface LambdaTest3 {
    int lambda(int integer, int integer2);
}

class Impls implements LambdaTest {
    @Override
    public void lambda() {
        System.out.println("Impls");
    }
}