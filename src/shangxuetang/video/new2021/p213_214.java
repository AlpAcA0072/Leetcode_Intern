package shangxuetang.video.new2021;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class p213_214 {
    public static void main(String[] args) {
        // 通过新建Comparator实现排序
        Set<YourClass> set1 = new TreeSet<>(new YourClassComparator());
        Set<YourClass> set2 = new TreeSet<>(new Comparator<YourClass>() {
            @Override
            public int compare(YourClass o1, YourClass o2) {
                return o1.getI() - o2.getI();
            }
        });

        // Class implements Comparable
        Set<YourComparableClass> set3 = new TreeSet<>();
    }
}

class YourClassComparator implements Comparator<YourClass> {
    @Override
    public int compare(YourClass o1, YourClass o2) {
        return o1.getI() - o2.getI();
    }
}

class YourClass {
    private int i;
    private String str;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public YourClass(int i, String str) {
        this.i = i;
        this.str = str;
    }

    public YourClass() {
    }

    @Override
    public String toString() {
        return "YourClass{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }
}

class YourComparableClass implements Comparable<YourComparableClass> {
    private int i;
    private String str;

    @Override
    public int compareTo(@NotNull YourComparableClass o) {
        return this.i - o.i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public YourComparableClass(int i, String str) {
        this.i = i;
        this.str = str;
    }

    public YourComparableClass() {
    }

    @Override
    public String toString() {
        return "YourClass{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }
}