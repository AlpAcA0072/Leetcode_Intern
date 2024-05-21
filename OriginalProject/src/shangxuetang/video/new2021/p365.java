package shangxuetang.video.new2021;

import java.io.RandomAccessFile;


/**
 * RandomAccessFile的特点在于任意访问文件的任意位置，可以说是基于字节访问的，可通过getFilePointer()获取当前指针所在位置<p>
 * 可通过seek()移动指针，这体现了它的任意性，也是其与其他I/O流相比，自成一派的原因<p>
 * 一句话总结：seek用于设置文件指针位置，设置后ras会从当前指针的下一位读取到或写入到
 */
public class p365 {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("OriginalProject/src/resource/p365.txt", "rw")) {
            raf.writeInt(1);
            raf.writeUTF("line1");
            raf.writeDouble(.1D);
            raf.writeBoolean(true);
            raf.writeByte(1);
            raf.writeChar('1');

            // 4 byte = 1 int
            // Sets the file-pointer offset, measured from **the beginning of this file**, at which the next read or write occurs
            raf.seek(4);
            System.out.println(raf.readUTF());
            System.out.println(raf.readDouble());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
