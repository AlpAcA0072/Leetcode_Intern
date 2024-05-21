package shangxuetang.video.new2021;

import java.io.*;

/**
 * 字符输出流
 */
public class p355 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("OriginalProject/src/resource/ReaderWriterTest.txt")));
             PrintWriter pw = new PrintWriter("OriginalProject/src/resource/p355_output.txt")) {
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}