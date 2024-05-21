package shangxuetang.video.new2021;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 自定义缓冲区数组
 * 2 的整数幂，缓冲区数组，提高读写效率
 */
public class p342 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("OriginalProject/src/resource/test.png"); FileOutputStream fos = new FileOutputStream("OriginalProject/src/resource/p342_output.png")) {
            int temp;
            // 2 的整数幂，缓冲区数组，提高读写效率
            byte[] buffer = new byte[1024];

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
