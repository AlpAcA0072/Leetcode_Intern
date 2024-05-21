package shangxuetang.video.new2021.FileCopyTools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTools {
    public static void main(String[] args) {
        copyFile("OriginalProject/src/resource/test.png", "OriginalProject/src/resource/FileCopyTools_output.png");
    }

    /**
     * 文件拷贝方法
     */
    public static void copyFile(String src, String des) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src)); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des))) {
            int temp;
            while ((temp = bis.read()) != -1) {
                bos.write(temp);
                System.out.println(temp);
            }
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
