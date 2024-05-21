package shangxuetang.video.new2021;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * File相关方法
 */
public class p338_339 {
    public static void main(String[] args) {
        // File
        File file = new File("OriginalProject/src/resource/p338.txt");
        if (!file.exists()) {
            try {
                System.out.println(file.createNewFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
        System.out.println("-------------------------------------------------------");
        // Path
        File path = new File("OriginalProject/src/resource/p338_dir");
        System.out.println(path.mkdir());
        System.out.println("-------------------------------------------------------");
        File recursivePath = new File("OriginalProject/src/resource/p338_outerDir/innerDir");
        System.out.println(recursivePath.mkdir());
        System.out.println(recursivePath.mkdirs());
        System.out.println("-------------------------------------------------------");
        System.out.println(path.isFile());
        System.out.println(path.isDirectory());
        System.out.println("-------------------------------------------------------");
        System.out.println(path.getAbsolutePath());
        System.out.println(path.getParent());
        System.out.println(path.getParentFile());
        System.out.println("-------------------------------------------------------");
        File parents = path.getParentFile().getParentFile();
        System.out.println(Arrays.toString(parents.list()));
        System.out.println(Arrays.toString(parents.listFiles()));
    }
}
