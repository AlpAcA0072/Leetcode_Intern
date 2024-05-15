package shangxuetang.video.old2019;

public class p82 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.shout();
        System.out.println("-------------------");
        // 父类引用变量可以指向子类对象。
        Animal d = new Dog();
        d.shout();
        System.out.println("-------------------");
        Dog d2 = (Dog) d;
//        Cat c2 = (Cat) d;
        System.out.println("-------------------");
        System.out.println(a instanceof Animal);
        System.out.println(a instanceof Dog);
        System.out.println("-------------------");
        System.out.println(d instanceof Animal);
        System.out.println(d instanceof Dog);
        System.out.println("-------------------");
        A a2 = new A();
        a2.show();
        B b = new B();
        b.show();
    }
}

class Animal {
    public void shout() {
        System.out.println("Animal shout.");
    }
}

class Dog extends Animal {
    public void shout() {
        System.out.println("Dog shout.");
    }
}

class Cat extends Animal {
    public void shout() {
        System.out.println("Cat shout.");
    }
}

class A {
    public void show() {
        show2();
    }

    public void show2() {
        System.out.println("A");
    }
}

class B extends A {
    public void show2() {
        System.out.println("B");
    }
}

class C extends B {
    public void show() {
        super.show();
    }

    public void show2() {
        System.out.println("C");
    }
}

class p82_plus {
    /**
     * <a href="https://zhuanlan.zhihu.com/p/354294694">多态中的向上转型与向下转型</a><br>
     * <br>
     * 输出结果：<br>
     * 1--A and A<br>
     * 2--A and A<br>
     * 3--A and D<br>
     * 4--B and A<br>
     * 5--B and A<br>
     * 6--A and D<br>
     * 7--B and B<br>
     * 8--B and B<br>
     * 9--A and D
     */
    public static void main(String[] args) {
        A2 a1 = new A2();
        A2 a2 = new B2();
        B2 b = new B2();
        C2 c = new C2();
        D2 d = new D2();
        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }
}

class A2 {
    public String show(D2 obj) {
        return ("A and D");
    }

    public String show(A2 obj) {
        return ("A and A");
    }
}

class B2 extends A2 {
    public String show(B2 obj) {
        return ("B and B");
    }

    public String show(A2 obj) {
        return ("B and A");
    }
}

class C2 extends B2 {
}

class D2 extends B2 {
}