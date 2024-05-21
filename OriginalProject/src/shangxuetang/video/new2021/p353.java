package shangxuetang.video.new2021;

import java.io.*;

/**
 * 通过转换流实现键盘输入控制台输出
 */
public class p353 {
    public static void main(String[] args) {
        InputStream is = System.in;
        OutputStream os = System.out;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            // InputStreamReader: byte to character
            // OutputStreamWriter: character to byte
            // System.in -> InputStreamReader -> BufferedReader -> str -> BufferedWriter -> OutputStreamWriter -> System.out
//            int input = is.read();
//            System.out.println((char) input);
            String str;
            // 输入-1终止
            // 也可以ctrl + c终止
            while (!(str = br.readLine()).equals("-1")) {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
