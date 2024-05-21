package shangxuetang.video.new2021.FileCopyTools;

import java.io.*;

public class FileCopyTools2 {
    public static void main(String[] args) {
        copyFile("OriginalProject/src/resource/ReaderWriterTest.txt", "OriginalProject/src/resource/FileCopyTools2_output.txt");
    }

    /**
     * 使用字符流实现文件拷贝
     */
    public static void copyFile(String src, String des) {
        try (FileReader fileReader = new FileReader(src); FileWriter fileWriter = new FileWriter(des)) {
            int temp;
            char[] buffer = new char[1024];
            while ((temp = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, temp);
                System.out.println(temp);
            }
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
