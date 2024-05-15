package shangxuetang.video.new2021;

public class p110 {
    public static void main(String[] args) {
        Outer1 o = new Outer1();
        Outer1.Inner1 i = o.new Inner1();
        i.showInner1();
    }
}

class Outer1 {
    private int age = 10;

    private void show() {
        System.out.println("Outer1.show");
        System.out.println("Outer1.age: " + age);
        System.out.println("Inner1.age: " + new Inner1().age);
    }

    public class Inner1 {
        private String name = "name";
        private int age = 20;

        public void showInner1() {
            System.out.println("Inner1.showInner1");
            System.out.println("Inner1.age: " + age);
            System.out.println("Outer.age: " + Outer1.this.age);
            System.out.println("-------------------------------");
            show(); // 内部类可以直接使用外部类的成员
        }
    }
}


class Face {
    private String shape = "face shape";

    class Nose {
        private String shape = "Nose shape";

        public void breath() {
            System.out.println("breath");
            System.out.println(Face.this.shape);
            System.out.println(shape);
        }

        class Ear {

        }

        class Eye {

        }
    }

    public static void main(String[] args) {
        Face.Nose nose = new Face().new Nose();
        nose.breath();
    }
}
