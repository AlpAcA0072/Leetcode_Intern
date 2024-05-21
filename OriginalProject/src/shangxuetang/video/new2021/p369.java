package shangxuetang.video.new2021;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;

/**
 * Apache IO JAR
 * FileUtils & IOUtils
 */
public class p369 {
    public static void main(String[] args) {
        try {
            String content = FileUtils.readFileToString(new File("OriginalProject/src/resource/ReaderWriterTest.txt"), "utf-8");
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
