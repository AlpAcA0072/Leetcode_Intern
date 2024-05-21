package shangxuetang.video.new2021;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class p356_357 {
    public static void main(String[] args) {
        byte[] bytes = "abcdefg".getBytes();
        // 该构造方法的参数是一个字节数组，这个字节数组是输入源
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int temp = 0;
            StringBuilder sb = new StringBuilder();
            while ((temp = bais.read()) != -1) {
//                System.out.println(temp);
                System.out.println((char) temp);
                sb.append((char) temp);
                baos.write(temp);
            }
            System.out.println(sb);
            byte[] outputStreamArr = baos.toByteArray();
            for (byte b : outputStreamArr) {
                System.out.print((char) b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
