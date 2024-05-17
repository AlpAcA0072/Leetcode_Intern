package shangxuetang.video.new2021.Generics;

public class TestGenericMethod<ClassT> {
    /**
     * 使用自定义泛型的非静态泛型方法，无返回值
     *
     * @param name 自定义泛型参数
     */
    public <T> void printName(T name) {
        System.out.println(name);
    }

    /**
     * 使用自定义泛型的非静态泛型方法，有返回值
     *
     * @param name 自定义泛型参数
     * @return 自定义泛型返回值
     */
    public <T> T getName(T name) {
        return name;
    }

    /**
     * 使用类定义泛型的非静态泛型方法，无返回值
     *
     * @param name 泛型类的泛型参数
     */
    public void printName2(ClassT name) {
        System.out.println(name);
    }

    /**
     * 使用类定义泛型的非静态泛型方法，有返回值
     *
     * @param name 泛型类的泛型参数
     * @return 泛型类的泛型返回值
     */
    public ClassT getName2(ClassT name) {
        return name;
    }

    /**
     * 使用自定义泛型的静态泛型方法，无返回值
     *
     * @param name 自定义泛型参数
     */
    public static <T> void printStaticName(T name) {
        System.out.println(name);
    }

    /**
     * 使用自定义泛型的静态泛型方法，有返回值
     *
     * @param name 自定义泛型参数
     * @return 自定义泛型返回值
     */
    public static <T> T getStaticName(T name) {
        return name;
    }

    /**
     * 可变参数类型泛型方法
     *
     * @param args 可变泛型参数
     */
    @SafeVarargs
    public final <T> void printArgs(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        // non-static generic method
        TestGenericMethod<Integer> m1 = new TestGenericMethod<>();

        // 自定义泛型返回值
        m1.printName("String name");
        m1.printName(123);
        System.out.println("--------------------------------------------");

//        String s = m1.getName(1);
        String s = m1.getName("String name");
        System.out.println(s);
        Integer i = m1.getName(123);
        System.out.println(i);
        System.out.println("--------------------------------------------");


        // 可变参数泛型方法
        String[] strings = new String[]{"s1", "s2", "s3"};
        Integer[] integers = new Integer[]{1, 2, 3};
        Object[] objects = new Object[]{"1", 2, '3'};
        m1.printArgs(strings);
        m1.printArgs(integers);
        m1.printArgs(objects);
        System.out.println("--------------------------------------------");


        // 类定义泛型返回值
        m1.printName2(1);
        Integer i2 = m1.getName2(1);
        System.out.println(i2);
        System.out.println("--------------------------------------------");


        // 自定义泛型返回值
        // static generic method
        TestGenericMethod.printStaticName("static String name");
        TestGenericMethod.printStaticName(123);

        String s2 = TestGenericMethod.getStaticName("static String name");
        System.out.println(s2);
        Integer i3 = TestGenericMethod.getStaticName(123);
        System.out.println(i3);
        System.out.println("--------------------------------------------");

    }
}
