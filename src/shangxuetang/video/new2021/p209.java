package shangxuetang.video.new2021;

import java.util.HashSet;
import java.util.Objects;

public class p209 {
    public static void main(String[] args) {
        HashSet<TestSet> hashSet = new HashSet<>();
        hashSet.add(new TestSet());
        hashSet.add(new TestSet());

        hashSet.add(new TestSet("1", 1));
        hashSet.add(new TestSet("1", 1));

        System.out.println(hashSet);
    }
}


class TestSet {
    private String string;
    private int anInt;

    public TestSet() {
    }

    public TestSet(String string, int anInt) {
        this.string = string;
        this.anInt = anInt;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Run equals...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestSet testSet = (TestSet) o;
        return anInt == testSet.anInt && Objects.equals(string, testSet.string);
    }

    @Override
    public int hashCode() {
        System.out.println("Run hashCode...");
        return Objects.hash(string, anInt);
    }

    @Override
    public String toString() {
        return "TestSet{" +
                "string='" + string + '\'' +
                ", anInt=" + anInt +
                '}';
    }
}