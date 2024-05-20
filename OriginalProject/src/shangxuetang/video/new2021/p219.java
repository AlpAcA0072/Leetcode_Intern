package shangxuetang.video.new2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class p219 {
    public static void main(String[] args) {
        Map<Integer, String> maps = new HashMap<Integer, String>();
        maps.put(3, "str3");
        maps.put(2, "str2");
        maps.put(4, "str4");
        maps.put(1, "str1");
        maps.put(5, "str5");
        Set<Map.Entry<Integer, String>> sets = maps.entrySet();
        for (Map.Entry<Integer, String> entry : sets) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }
    }
}
