package shangxuetang.video.new2021;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 字节输入输出流
 * available()方法预定义缓冲数组长度
 */
public class p343 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("OriginalProject/src/resource/test.png"); FileOutputStream fos = new FileOutputStream("OriginalProject/src/resource/p343_output.png")) {
            int temp;
            // 预估长度，缓冲区数组，提高读写效率
            // 3822129 for test.png (EVA's Asuka)
            // 空间换效率
            byte[] buffer = new byte[fis.available()];

            // 单字节读写
            while ((temp = fis.read(buffer)) != -1) {
                System.out.println(temp);
                fos.write(buffer);
//                fos.write(temp);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
