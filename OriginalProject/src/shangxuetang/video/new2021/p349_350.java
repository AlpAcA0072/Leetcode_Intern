package shangxuetang.video.new2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符输入输出缓冲流
 */
public class p349_350 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("OriginalProject/src/resource/ReaderWriterTest.txt")); BufferedWriter bw = new BufferedWriter(new FileWriter("OriginalProject/src/resource/p349_output.txt"))) {
            String temp;
            // br.readLine():
            // A String containing the contents of the line, **not** including any **line-termination characters**, or null if the end of the stream has been reached without reading any characters
            while ((temp = br.readLine()) != null) {
                bw.write(temp);
                // 无换行符
                System.out.print(temp);
                bw.newLine();
            }
            bw.write("new line");
            bw.newLine();
            bw.write("new line");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
