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