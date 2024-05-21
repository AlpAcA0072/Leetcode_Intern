package shangxuetang.video.new2021;

import java.io.*;
import java.util.Objects;

/**
 * 对象流
 */
public class p361 {
    public static void main(String[] args) {
        TestClass testClass = new TestClass(1, "test1", "test2");
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("OriginalProject/src/resource/p361_ObjectOutput")));
        ) {
            oos.writeInt(11111);
            oos.writeDouble(.1D);
            oos.writeChar('a');
            oos.writeByte(1);
            oos.writeBoolean(true);
            oos.writeUTF("String");
            oos.writeObject(testClass);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 读入顺序必须和输出顺序一致，否则会报错
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("OriginalProject/src/resource/p361_ObjectOutput")))) {
            System.out.println("int: " + ois.readInt());
            System.out.println("double: " + ois.readDouble());
            System.out.println("char: " + ois.readChar());
            System.out.println("byte: " + ois.readByte());
            System.out.println("bool: " + ois.readBoolean());
            System.out.println("String: " + ois.readUTF());
            TestClass testClass1 = (TestClass) ois.readObject();
            System.out.println("If Object read equals to the written Object: " + testClass.equals(testClass1));
            System.out.println("Object: " + testClass1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TestClass implements Serializable {
    private int anInt;
    private String string;
    private String string2;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "anInt=" + anInt +
                ", string='" + string + '\'' +
                ", string2='" + string2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestClass testClass = (TestClass) o;
        return anInt == testClass.anInt && Objects.equals(string, testClass.string) && Objects.equals(string2, testClass.string2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt, string, string2);
    }

    public TestClass(int anInt, String string, String string2) {
        this.anInt = anInt;
        this.string = string;
        this.string2 = string2;
    }

    public TestClass() {

    }
}