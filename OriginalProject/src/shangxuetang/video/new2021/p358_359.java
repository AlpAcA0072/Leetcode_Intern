package shangxuetang.video.new2021;

import java.io.*;

/**
 * 数据输入输出流
 */
public class p358_359 {
    public static void main(String[] args) {
        // 输出文件是乱码，自带数据和类型信息
        // 在读入的时候就不用转换数据类型了
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("OriginalProject/src/resource/DataOutputStream_output.txt")))) {
            dos.write(1);
            dos.writeChar('c');
            dos.writeInt(11111);
            dos.writeDouble(.1D);
            dos.writeBoolean(true);
            dos.writeUTF("String");
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("OriginalProject/src/resource/DataOutputStream_output.txt")))) {
            // 可以直接读取数据，读取数据的顺序必须与写入一致，否则不能正确读取数据
            System.out.println("byte: " + dis.read());
            System.out.println("char: " + dis.readChar());
            System.out.println("int: " + dis.readInt());
            System.out.println("double: " + dis.readDouble());
            System.out.println("bool: " + dis.readBoolean());
            System.out.println("string: " + dis.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
