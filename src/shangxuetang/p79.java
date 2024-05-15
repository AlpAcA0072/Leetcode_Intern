package shangxuetang;

public class p79 {
    public static void main(String[] args) {
        FatherClass f = new FatherClass();
        System.out.println("---------------------");
        f.f();
        System.out.println("---------------------");
        ChildClass c = new ChildClass();
        System.out.println("---------------------");
        c.f();
    }
}

class FatherClass {
    protected int value;

    public FatherClass() {
        System.out.println("new FatherClass");
    }

    public void f() {
        value = 1;
        System.out.println("FatherClass.value=" + value);
    }
}

class ChildClass extends FatherClass {
    private int value;

    public ChildClass() {
        System.out.println("new ChildClass");
    }

    @Override
    public void f() {
        super.f();
        value = 2;
        System.out.println("ChildClass.value=" + value);
        System.out.println(value);
        System.out.println(super.value);
    }
}