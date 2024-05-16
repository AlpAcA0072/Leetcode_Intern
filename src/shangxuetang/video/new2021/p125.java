package shangxuetang.video.new2021;

public class p125 {
    public static void main(String[] args) {
        Integer i1 = 120;
        Integer i2 = 120;
        System.out.println(i1);
        System.out.println(i2);
        System.out.println("-----------------------");
        System.out.println(i1 == i2); // true
        System.out.println(i1.equals(i2));
        System.out.println("-----------------------");
        i1 += 3;
        System.out.println(i1);
        System.out.println(i2);
        System.out.println("-----------------------");
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println("-----------------------");
        i1 -= 3;
        System.out.println(i1 == i2); // true
        System.out.println(i1.equals(i2));
    }
}
