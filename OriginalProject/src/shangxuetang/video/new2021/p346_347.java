package shangxuetang.video.new2021;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符输入输出流
 */
public class p346_347 {
    public static void main(String[] args) {
        // FileWriter 默认覆盖

        try (FileReader fileReader = new FileReader("OriginalProject/src/resource/ReaderWriterTest.txt"); FileWriter fileWriter = new FileWriter("OriginalProject/src/resource/p346_output.txt"); FileWriter fileWriter2 = new FileWriter("OriginalProject/src/resource/p346_output.txt", true)) {
            int temp;
            while ((temp = fileReader.read()) != -1) {
                fileWriter.write(temp);
//                System.out.println(temp);
                System.out.println((char) temp);
            }
            // 回车(回到行首) + 换行(换到下一行)
            // Unix系统里，每行结尾只有"<换行>"，即"\n"；
            // Windows系统里面，每行结尾是"<回车><换行>"，即"\r\n"；
            // Mac系统里，每行结尾是"<回车>"。
            fileWriter.write("\r\n");
            fileWriter.flush();

            // append = true 则为追加
            fileWriter2.write("测试追加");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
