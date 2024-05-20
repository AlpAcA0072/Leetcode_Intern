import org.jetbrains.annotations.NotNull;

public class MyInteger {
    public int value;
    private final static MyInteger[] cache;
    public static final int CACHE_LOWER_BOUND = -128;
    public static final int CACHE_UPPER_BOUND = 127;

    static {
        cache = new MyInteger[CACHE_UPPER_BOUND - CACHE_LOWER_BOUND + 1];
        for (int i = CACHE_LOWER_BOUND; i <= CACHE_UPPER_BOUND; i++) {
            cache[i - CACHE_LOWER_BOUND] = new MyInteger(i);
        }
    }

    public MyInteger add(@NotNull MyInteger integer) {
        return this.add(integer.value);
    }

    public MyInteger add(int integer) {
        this.value += integer;
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static MyInteger valueOf(int integer) {
        if (integer >= CACHE_LOWER_BOUND && integer <= CACHE_UPPER_BOUND) {
            return cache[integer - CACHE_LOWER_BOUND];
        }
        return new MyInteger(integer);
    }

    private MyInteger(int integer) {
        this.value = integer;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        MyInteger cache = MyInteger.valueOf(1);
        MyInteger mi = MyInteger.valueOf(300);
        System.out.println(cache);
        System.out.println(mi);
    }
}
