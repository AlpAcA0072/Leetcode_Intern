package shangxuetang.video.new2021;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 字节缓冲流
 */
public class p344 {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("OriginalProject/src/resource/test.png")); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("OriginalProject/src/resource/p344_output.png"))) {
            int temp = 0;
            while ((temp = bis.read()) != -1) {
                // 缓冲流默认缓冲区长度为8192 =  2 ^ 13
                bos.write(temp);
//                System.out.println(temp);
            }
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
