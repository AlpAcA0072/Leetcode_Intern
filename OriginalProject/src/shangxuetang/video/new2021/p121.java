package shangxuetang.video.new2021;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class p121 {
    public static void main(String[] args) {
        Human[] humans = new Human[3];
        for (int i = 0; i < humans.length; i++) {
            humans[i] = new Human();
        }
        humans[0].age = 1;
        humans[1].age = 3;
        humans[2].age = 2;
        Arrays.sort(humans);
        System.out.println(Arrays.toString(humans));
    }
}

class Human implements Comparable<Human> {
    public int age;

    @Override
    public int compareTo(@NotNull Human o) {
        return o.age - this.age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}