package shangxuetang.video.new2021;

import java.util.Arrays;

public class p136 {
    public static void main(String[] args) {
        for (Season s : Season.values()) {
            System.out.println(s);
            System.out.println(s.ordinal());
        }
        Season[] seasons = Season.values();
        Arrays.fill(seasons, Season.FESTIVAL);
        for (int i = 0; i < seasons.length; i++) {
            seasons[i] = Season.valueOf("SUMMER");
        }
    }
}

enum Season {
    SPRING, SUMMER, FESTIVAL, WINTER;
}