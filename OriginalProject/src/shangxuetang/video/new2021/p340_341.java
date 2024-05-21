package shangxuetang.video.new2021;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 字节输入输出流
 * 单字节读写
 */
public class p340_341 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("OriginalProject/src/resource/test.png"); FileOutputStream fos = new FileOutputStream("OriginalProject/src/resource/p340_output.png")) {
            int temp;
            // 单字节读写
            while ((temp = fis.read()) != -1) {
                System.out.println(temp);
                fos.write(temp);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
