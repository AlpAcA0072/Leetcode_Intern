package shangxuetang.video;

public class p82_plus {
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