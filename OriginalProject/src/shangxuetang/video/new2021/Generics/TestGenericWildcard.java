package shangxuetang.video.new2021.Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.zhihu.com/question/20400700/answer/117464182"><? extends T>和<? super T> [知乎]</a>
 * <br>
 * <a href="https://blog.csdn.net/qq_40587575/article/details/78858249">Java泛型通配符“？”的使用 [CSDN]</a>
 */
public class TestGenericWildcard {
    public static void main(String[] args) throws Exception {
        List<Integer> listInteger = new ArrayList<>();
        List<String> listString = new ArrayList<>();

        /*
        printCollection 方法的参数类型是 Collection<Object>。
        但是，List<Integer> 和 List<String> 的类型分别是 Collection<Integer> 和 Collection<String>。
        在 Java 的泛型中，Collection<Object> 并不等同于 Collection<Integer> 或 Collection<String>。即使 Integer 和 String 是 Object 的子类，但 Collection<Integer> 和 Collection<Object> 之间没有继承关系。
        因此，编译器会报类型不匹配的错误。

        即使 Integer 和 String 是 Object 的子类，但 Collection<Integer> 和 Collection<Object> 之间没有继承关系：
        这涉及到 Java 中泛型的一个重要概念：不变性（Invariance）。
        在 Java 中，泛型是不变的，这意味着即使类型 A 是类型 B 的子类型，也不意味着 Collection<A> 是 Collection<B> 的子类型。

        举个具体的例子：
        Integer 是 Object 的子类。
        但是 Collection<Integer> 不是 Collection<Object> 的子类。

        为什么泛型是不变的？
        泛型的不变性主要是为了保证类型安全。假设 Collection<Integer> 是 Collection<Object> 的子类，我们可能会遇到类型安全问题：
        Collection<Integer> intCollection = new ArrayList<>();
        Collection<Object> objCollection = intCollection; // 假设这是合法的

        objCollection.add("string"); // 这行代码会引入问题，因为我们在一个应该只包含 Integer 的集合中添加了一个 String
        在这个例子中，如果允许 objCollection 引用 intCollection，那么我们可以向 intCollection 中添加非 Integer 类型的元素，从而破坏了 intCollection 的类型约束。这会导致运行时错误，但编译器无法检测到这一点。

        通配符和协变性
        为了在某些情况下能够处理类似的情况，Java 引入了通配符和协变性（covariance）：
        Collection<?> 是一种通配符类型，表示可以接受任何类型的 Collection。这允许方法能够处理不同类型的集合，而无需指定确切的类型。
        Collection<? extends Object> 也是一种通配符类型，表示可以接受任何类型的 Collection，其中类型是 Object 或其子类型。
        通配符使得方法能够处理多种类型的集合，而不会引入类型安全问题。

        printCollection(Collection<Object> collection)
        这个方法只接受 Collection<Object> 类型的参数，因此不能传入 Collection<Integer> 或 Collection<String>。这是因为泛型Collection<E>的不变性，Collection<Integer> 并不是 Collection<Object> 的子类型。

        printCollection2(Collection<?> collection)
        这个方法接受任何类型的 Collection，因为它使用了通配符 ?。这意味着你可以传入 Collection<Integer>、Collection<String> 等。
        结论：
        泛型的不变性确保了类型安全，防止了在集合中添加不符合类型约束的元素。而通配符提供了一种灵活的方式，允许方法能够处理多种类型的集合，而不会引入类型安全问题。这就是为什么 Collection<Integer> 和 Collection<Object> 之间没有继承关系的原因。
         */
//        printCollection(listInteger);
//        printCollection(listString);
        System.out.println("---------------------------------------------------------------");

        /*
        Collections.singleton(listInteger) 返回的是一个包含单个元素（即 listInteger）的集合，类型为 Collection<List<Integer>>。
        由于 listInteger 是 List<Integer> 类型，并且 List<Integer> 是 Object 的子类型，因此 Collection<List<Integer>> 是 Collection<Object> 类型的有效实例。
        换句话说，这里传入的参数是包含一个 List<Integer> 对象的集合，而不是包含 Integer 对象的集合，因此符合 Collection<Object> 的类型要求。
         */
        printCollection(Collections.singleton(listInteger));
        printCollection(Collections.singleton(listString));
        System.out.println("---------------------------------------------------------------");

        /*
        printCollection2 方法的参数类型是 Collection<?>，表示可以接受任何类型的集合。
        由于 ? 是一个通配符，表示未知类型，所以 Collection<?> 可以匹配 Collection<Integer>、Collection<String> 等任何类型的集合。
        因此，listInteger 和 listString 都可以传递给 printCollection2 方法。
         */
        printCollection2(listInteger);
        printCollection2(listString);
        System.out.println("---------------------------------------------------------------");

        /*
        printCollection3(listInteger) 和 printCollection3(listDouble) 可以正常工作，因为 Integer 和 Double 都是 Number 的子类。
        printCollection3(listString) 会报编译错误，因为 String 不是 Number 的子类。
         */
        List<Double> listDouble = new ArrayList<>();
        printCollection3(listInteger);
        printCollection3(listDouble);
//        printCollection3(listString);
        System.out.println("---------------------------------------------------------------");

        /*
        第一行：
        泛型类型声明：List<? extends Number> 表示一个类型为 Number 或其子类型的列表。这里使用的是上界通配符 ? extends Number，这意味着这个列表可以持有任何 Number 的子类型。
        赋值操作：wildcardListInteger 被初始化为一个 ArrayList<Integer> 对象。由于 Integer 是 Number 的子类，因此 ArrayList<Integer> 可以赋值给 List<? extends Number>。
        换句话说，wildcardListInteger 是一个可以持有任何 Number 子类型元素的列表引用，在这个具体例子中，它持有的是 Integer 类型的元素。

        第二行：
        泛型类型声明：同样，List<? extends Number> 表示一个类型为 Number 或其子类型的列表。
        赋值操作：wildcardListString 试图被初始化为一个 ArrayList<String> 对象。由于 String 不是 Number 的子类，这会导致编译错误。
        换句话说，wildcardListString 只能引用一个持有 Number 或其子类型元素的列表，而 ArrayList<String> 并不满足这个条件，因此这行代码会导致编译错误。

        更深入的解释
        上界通配符 <? extends Number>
        上界通配符 <? extends Number> 表示一个类型参数，它是 Number 的子类型。通配符 ? 表示未知的具体类型，但我们知道它必须是 Number 或其子类型。下面是一些重要的概念：
        读操作：你可以从 List<? extends Number> 中读取元素，读取的元素类型是 Number，因为这保证了类型安全。
        写操作：你不能向 List<? extends Number> 中写入元素，因为编译器无法确定具体的子类型是什么。例如，它可能是 List<Integer>，但你试图添加 Double，这会导致类型不安全。因此，唯一可以添加的值是 null，因为它适用于所有引用类型。
         */
        List<? extends Number> wildcardListInteger = new ArrayList<Integer>();
//        List<? extends Number> wildcardListString = new ArrayList<String>();

        // 编译错误：无法添加元素，除了 null
//        wildcardListInteger.add(1);   // 错误
//        wildcardListInteger.add(1.1); // 错误
        /*
        上界通配符的读取操作
        使用上界通配符时，你可以安全地从集合中读取元素。因为无论通配符具体代表什么类型，它至少是 Number 的一个子类型。由于编译器知道这一点，它允许读取操作并保证返回类型为 Number。
        上界通配符的写入操作
        使用上界通配符时，你不能向集合中添加元素，因为编译器无法确定集合的具体类型。虽然你知道这个集合中的元素都是 Number 的子类型，但具体是什么子类型是不确定的。因此，为了保证类型安全，编译器禁止任何写操作，除了添加 null。
         */
        wildcardListInteger.add(null); // 唯一允许的

        // 正确的操作：读取
        Number number = wildcardListInteger.get(0);
//        Integer integer = wildcardListInteger.get(0);
        System.out.println(number);
        System.out.println("---------------------------------------------------------------");

        /*
        使用 List<? extends Number> 这种带有上界通配符的泛型声明的主要目的是为了实现类型安全的读取操作，而不是写入操作。这种代码在以下几种情况下特别有用：
        1.泛型方法参数
        当你需要一个方法能够接受不同类型的 Number 子类列表作为参数，但你不关心具体的子类类型时，使用上界通配符是很有帮助的。例如，你想编写一个方法来处理所有类型的数字列表：
        public static void printNumbers(List<? extends Number> numbers) {
            for (Number number : numbers) {
        System.out.println(number);
            }
        }

        2.泛型类或接口的字段或返回值
        当你设计一个类或接口时，有时你需要存储或返回一个类型不确定但在某个范围内的泛型对象。例如，假设你有一个数据处理器类，它可以处理不同类型的数字数据：
        public class DataProcessor {
            private List<? extends Number> data;

            public DataProcessor(List<? extends Number> data) {
                this.data = data;
            }

            public void processData() {
                for (Number number : data) {
                    System.out.println(number.doubleValue());
                }
            }
        }

        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);

        DataProcessor integerProcessor = new DataProcessor(integers);
        DataProcessor doubleProcessor = new DataProcessor(doubles);

        integerProcessor.processData();
        doubleProcessor.processData();

        3.API 设计中的通用接口
        在设计通用库或 API 时，使用上界通配符可以提高灵活性和可重用性。例如，一个统计库可以提供计算平均值的方法，该方法可以接受任何类型的数字列表：
        public class Statistics {
            public static double calculateAverage(List<? extends Number> numbers) {
                double sum = 0.0;
                for (Number number : numbers) {
                    sum += number.doubleValue();
                }
                return sum / numbers.size();
            }
        }
        这个方法可以用于各种类型的数字列表：
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);

        double avgIntegers = Statistics.calculateAverage(integers);
        double avgDoubles = Statistics.calculateAverage(doubles);

        System.out.println("Average of integers: " + avgIntegers);
        System.out.println("Average of doubles: " + avgDoubles);

        4.适配器模式
        在设计模式中，尤其是适配器模式中，使用上界通配符可以适配不同类型的集合。例如，你可能有一个接口方法可以接受不同类型的数字集合，然后在适配器中实现：
        public interface NumberProcessor {
            void process(List<? extends Number> numbers);
        }

        public class IntegerProcessor implements NumberProcessor {
            @Override
            public void process(List<? extends Number> numbers) {
                for (Number number : numbers) {
                    System.out.println(number.intValue());
                }
            }
        }
        总结
        使用 List<? extends Number> 的主要目的是为了实现类型安全的读取操作，而不关心具体的子类型。在上述情况下，这种设计提供了灵活性和重用性，使得代码可以处理多种类型的数字数据，而无需重复编写相同的逻辑。尽管不能向列表中添加元素，但可以安全地读取元素，并进行相应的处理。
        上界通配符可以使用返回值，但是不可以为方法提供参数：使用上界通配符（如 ? extends Number）时，对于集合的操作，读取操作是安全的，而写入操作是不安全的。
        上界通配符的读取操作
        使用上界通配符时，你可以安全地从集合中读取元素。因为无论通配符具体代表什么类型，它至少是 Number 的一个子类型。由于编译器知道这一点，它允许读取操作并保证返回类型为 Number。
        上界通配符的写入操作
        使用上界通配符时，你不能向集合中添加元素，因为编译器无法确定集合的具体类型。虽然你知道这个集合中的元素都是 Number 的子类型，但具体是什么子类型是不确定的。因此，为了保证类型安全，编译器禁止任何写操作，除了添加 null。
         */
        System.out.println("---------------------------------------------------------------");

        /*
        下界通配符可以为方法提供参数，但是不能使用返回值。
        下界通配符 <? super T> 主要用于表示某个泛型类型的子类型集合，确保可以安全地向集合中添加 T 类型的元素。使用下界通配符的典型场景是你希望能够向集合中添加某种类型的元素。
        允许写入但限制读取
        写操作是安全的：由于泛型类型至少是 T 或 T 的子类型，所以添加 T 类型的元素是安全的。
        读取操作受限：你只能读取到 Object 类型，因为你无法确定集合中的具体类型。
        在这段代码中，wildcardListNumber 被声明为 List<? super Integer> 类型，表示它可以持有 Integer 类型或 Integer 类型的子类型的元素。然后，它被初始化为一个 ArrayList<Number> 对象，因为 Number 是 Integer 的父类。
        当你调用 wildcardListNumber.add(1) 和 wildcardListNumber.add(2) 时，你向列表中添加了两个 Integer 类型的元素。因为你声明的是 List<? super Integer> 类型，编译器知道这个列表可以安全地接受 Integer 类型的元素，因为它们是 Integer 或 Integer 的子类型。
        然而，当你调用 wildcardListNumber.get(0) 时，你得到的是一个 Object 类型的引用。这是因为在 Java 中，泛型的类型擦除（type erasure）会导致在运行时丢失类型信息。编译器无法确定 wildcardListNumber 实际持有的是 Integer 类型还是 Number 类型的元素，因此它只能安全地将返回类型视为 Object。
        虽然在编译时你知道 wildcardListNumber 应该只包含 Integer 或 Integer 的子类型的元素，但在运行时这个信息已经丢失了，所以 get() 方法只能返回 Object 类型。
         */
        List<? super B> wildcardListB = new ArrayList<B>();
        List<? super B> wildcardListA = new ArrayList<A>();
        wildcardListB.add(new C());
        wildcardListB.add(new B());
//        wildcardListB.add(new A());
        Object objectC = wildcardListB.get(0);

        List<? super Integer> wildcardListNumber = new ArrayList<Number>(); // 这是正确的
        wildcardListNumber.add(1);  // 可以添加 Integer 类型的元素
        wildcardListNumber.add(2);  // 可以添加 Integer 类型的元素
        Object obj = wildcardListNumber.get(0);
//        Integer obj = wildcardListNumber.get(0);
        System.out.println(obj);
//        List<? super Integer> wildcardListByte = new ArrayList<Byte>(); // 这是错误的

        List<? super C> wildcardListSuperNumber = new ArrayList<A>();
        wildcardListSuperNumber.add(new C());
        printCollection4(wildcardListSuperNumber);
    }

    public static void printCollection(Collection<Object> collection) {
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }

    public static void printCollection2(Collection<?> collection) {
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }

    public static void printCollection3(Collection<? extends Number> collection) {
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }

    public static void printCollection4(Collection<? super C> collection) {
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }

    static class A {

    }

    static class B extends A {

    }

    static class C extends B {

    }
}

