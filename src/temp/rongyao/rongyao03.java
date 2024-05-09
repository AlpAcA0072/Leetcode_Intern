package temp.rongyao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class rongyao03 {
    static class fruit {
        int p = 0;
        int q = 0;
        String fruit = "";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        ArrayList<fruit> arr = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < num; i++) {
            fruit fr = new fruit();
            fr.fruit = in.next();
            fr.p = in.nextInt();
            fr.q = in.nextInt();
            arr.add(fr);
        }

//        while (in.hasNext()) {
//            fruit fr = new fruit();
//            fr.fruit = in.next();
//            fr.p = in.nextInt();
//            fr.q = in.nextInt();
//            arr.add(fr);
//        }
        fruit[] fruits = new fruit[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            fruits[i] = arr.get(i);
        }
        Arrays.sort(fruits, new Comparator<fruit>() {
            @Override
            public int compare(fruit o1, fruit o2) {
                if (o1.q != o2.q) {
                    return o1.q - o2.q;
                }
                return o1.p - o2.p;
            }
        });

        ArrayList<String> show = new ArrayList<>();
        for (fruit fruit : arr) {
            if (!show.contains(fruit.fruit)) {
                show.add(fruit.fruit);
            }
        }
        for (int i = 0; i < show.size(); i++) {
            String currFruit = show.get(i);
            for (int j = 0; j < arr.size(); j++) {
                if (fruits[j].fruit.equals(currFruit)) {
                    System.out.print(fruits[j].fruit + " ");
                    System.out.print(fruits[j].p + " ");
                    System.out.println(fruits[j].q);
                }
            }
        }
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.print(fruits[i].fruit + " ");
//            System.out.print(fruits[i].p + " ");
//            if (i != arr.size() - 1) {
//                System.out.println(fruits[i].q);
//            } else {
//                System.out.print(fruits[i].q);
//            }
//        }
    }
}
