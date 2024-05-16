package shangxuetang.video.new2021;

import java.sql.SQLException;

public class p139 {
    public static void main(String[] args) {
        System.out.println("1");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("2");

        System.out.println("-------------------------------------------");

        System.out.println("1");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("2");
    }

}
