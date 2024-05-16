package shangxuetang.video.new2021;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class p133 {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar = new GregorianCalendar(2020, 10, 9, 22, 10, 10);
        calendar = new GregorianCalendar(2020, Calendar.NOVEMBER, 9, 22, 10, 10);

        int year = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.YEAR, 2019);
        calendar.add(Calendar.MONTH, 1);
        System.out.println(year);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String week = dayOfWeek == 0 ? "日" : String.valueOf(dayOfWeek);
        System.out.println("星期" + week);

        Date date = calendar.getTime();
        calendar.setTime(date);
    }
}
