package shangxuetang.video.new2021;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class p135 {
    public static void main(String[] args) throws IOException {
        System.out.println("------------------------------------------------------");
        System.out.println(System.getProperties());
        System.out.println("------------------------------------------------------");
        System.out.println(System.getProperty("user.dir"));
        System.out.println("------------------------------------------------------");
        File f = new File(System.getProperty("user.dir"));
        boolean ifCreated = f.createNewFile();
        ifCreated = f.delete();
        ifCreated = f.mkdir(); // 父目录不存在则报错
        ifCreated = f.mkdirs(); // 父目录不存在则创建
        System.out.println("File是否存在: " + f.exists());
        System.out.println("File是否是目录: " + f.isDirectory());
        System.out.println("File是否是文件: " + f.isFile());
        System.out.println("File最后修改时间: " + new Date(f.lastModified()));
        System.out.println("File的大小: " + f.length());
        System.out.println("File的文件名: " + f.getName());
        System.out.println("File的目录路径: " + f.getPath());
    }
}
