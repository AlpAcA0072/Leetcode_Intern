package shangxuetang.video.new2021.FileCopyTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyTools3 {
    public static void main(String[] args) {
        copyFile("OriginalProject/src/resource/ReaderWriterTest.txt", "OriginalProject/src/resource/FileCopyTools3_output.txt");
    }

    /**
     * 基于字符缓冲流实现文件拷贝
     */
    public static void copyFile(String src, String des) {
        try (BufferedReader br = new BufferedReader(new FileReader(src)); BufferedWriter bw = new BufferedWriter(new FileWriter(des))) {
            String temp;
            while ((temp = br.readLine()) != null) {
                bw.write(temp);
                // 无换行符
                System.out.print(temp);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
