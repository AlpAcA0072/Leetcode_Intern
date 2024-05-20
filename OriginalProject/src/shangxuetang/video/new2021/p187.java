package shangxuetang.video.new2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p187 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");

        Object[] objects = arr.toArray();
        for (Object object : objects) {
            String str = (String) object;
            System.out.println(str);
        }
        System.out.println("-----------------------------------------------------");
        String[] strings1 = arr.toArray(new String[0]);
        System.out.println(Arrays.toString(strings1));
        System.out.println("-----------------------------------------------------");
        String[] strings2 = arr.toArray(new String[arr.size()]);
        System.out.println(Arrays.toString(strings2));
        System.out.println("-----------------------------------------------------");
        String[] strings3 = arr.toArray(new String[4]);
        System.out.println(Arrays.toString(strings3));

    }
}
