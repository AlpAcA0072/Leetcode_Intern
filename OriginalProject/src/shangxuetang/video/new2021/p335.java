package shangxuetang.video.new2021;

import java.io.FileInputStream;

public class p335 {
    public static void main(String[] args) {
        // 编辑配置 - 工作目录
        try (FileInputStream fis = new FileInputStream("OriginalProject/src/resource/test.txt")) {
            int i = fis.read();
            int i2 = fis.read();
            int i3 = fis.read();
            int i4 = fis.read();
            // 原内容 'a' 'b' 'c' '-1'(文件结尾)
            System.out.println(i);
            System.out.println((char) i);
            System.out.println(i2);
            System.out.println((char) i2);
            System.out.println(i3);
            System.out.println((char) i3);
            System.out.println(i4);
            System.out.println((char) i4);

            int temp = 0;
            StringBuilder sb = new StringBuilder();
            while ((temp = fis.read()) != -1) {
                // do sth...
                sb.append(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
