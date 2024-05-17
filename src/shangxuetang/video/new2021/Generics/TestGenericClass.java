package shangxuetang.video.new2021.Generics;

public class TestGenericClass<T> {
    private T flag;

    public T getFlag() {
        return flag;
    }

    public void setFlag(T flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        TestGenericClass<String> t1 = new TestGenericClass<>();
//        TestGeneric t1 = new TestGeneric();
        t1.setFlag("1");
        String flag = t1.getFlag();
    }
}
