package shangxuetang.video.new2021;

import java.io.File;
import java.io.FileReader;

public class p143 {
    public static void main(String[] args) {
        File f = new File(System.getProperty("user.dir"));
//        FileReader fileReader = new FileReader(f);
        try (FileReader fileReader = new FileReader("file path")) {
            char c = (char) fileReader.read();
            System.out.println(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
