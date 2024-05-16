package shangxuetang.video.new2021;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class p132 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(df.format(date));
        df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        System.out.println(df.format(date));
        df = new SimpleDateFormat("yyyy-MM-dd hh:ss");
        System.out.println(df.format(date));

        df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        date = df.parse("1970-3-1 10:30:20");
        System.out.println(date.getTime());
        date = df.parse("1970-3-1 10:30:10");
        System.out.println(date.getTime());

    }
}
