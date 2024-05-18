package shangxuetang.video.new2021;

import java.util.*;

public class p188 {
    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<>();
        Collections.addAll(arr1, "str1", "str2");

        String[] strings1 = {"str3", "str4"};
        Collections.addAll(arr1, strings1);

        String[] strings2 = {"str5", "str6"};
        arr1.addAll(List.of(strings2));

        String[] strings3 = {"str7", "str8"};
        arr1.addAll(Arrays.asList(strings3));
        System.out.println(arr1);
    }
}
