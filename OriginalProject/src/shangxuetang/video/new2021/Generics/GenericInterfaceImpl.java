package shangxuetang.video.new2021.Generics;

public class GenericInterfaceImpl implements TestGenericInterface<String> {
    @Override
    public String getName(String name) {
        return name;
    }


    public static void main(String[] args) {
        GenericInterfaceImpl g1 = new GenericInterfaceImpl();
        String string1 = g1.getName("String1");
        System.out.println(string1);

        TestGenericInterface g2 = new GenericInterfaceImpl();
        String string2 = (String) g2.getName("String2");
        System.out.println(string2);

        TestGenericInterface<String> g3 = new GenericInterfaceImpl();
        String string3 = g3.getName("String3");
        System.out.println(string3);
    }
}
