import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Main class to demonstrate various Java 8 features
public class Main {

    // Static variable to demonstrate lambda scope
    static int z = 9;

    public static void main(String[] args) {
        demonstrateFunctionalInterface();
        demonstrateListSorting();
        demonstrateTreeSetSorting();
        demonstrateCustomObjectSorting();
        demonstrateStreamFilterSum();
        demonstrateAnonymousClass();
        demonstrateLambdaModifyingStatic();
        demonstratePredicate();
        demonstrateBiPredicate();
        demonstrateFunctions();
        demonstrateImperativeVsStream();
    }

    // Demonstrates a custom functional interface with lambda
    private static void demonstrateFunctionalInterface() {
        MyInterface interfac = () -> "Hello";
        System.out.println(interfac.sayHello());
        System.out.println("----------------------------------------------------");
    }

    // Sort a list of integers in descending order using lambda
    private static void demonstrateListSorting() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 45, 256, 9, 4, 2));
        System.out.println("Before sorting: " + list);

        Collections.sort(list, (a, b) -> b - a);
        System.out.println("After sorting (Descending): " + list);
        System.out.println("=====================================================");
    }

    // TreeSet with custom comparator (Descending order)
    private static void demonstrateTreeSetSorting() {
        Set<Integer> sortedSet = new TreeSet<>((a, b) -> b - a);
        sortedSet.addAll(Arrays.asList(2, 45, 256, 9, 4, 2));

        System.out.println("TreeSet (Descending): " + sortedSet);
        System.out.println("=====================================================");
    }

    // Sort custom objects (Student) by ID in descending order
    private static void demonstrateCustomObjectSorting() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Ram"),
                new Student(9, "Shyam"),
                new Student(3, "Shiv"),
                new Student(7, "Kaal Bhairav"),
                new Student(5, "Maha Kali")
        ));

        students.sort((a, b) -> b.id - a.id);
        System.out.println("Sorted Students by ID (Descending): " + students);
        System.out.println("=====================================================");
    }

    // Filtering even numbers and summing using streams
    private static void demonstrateStreamFilterSum() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        int sumOfEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Sum of even numbers: " + sumOfEven);
        System.out.println("=====================================================");
    }

    // Demonstrates anonymous inner class
    private static void demonstrateAnonymousClass() {
        Employee employee = new Employee() {
            int abc = 4;

            @Override
            public String salary() {
                abc = 5;
                return "12000000000000";
            }

            @Override
            public String employeeName() {
                return "Harsh Vyas";
            }
        };

        System.out.println(employee.employeeName());
        System.out.println(employee.salary());
        System.out.println("=============================================================");
    }

    // Lambda that modifies a static variable
    private static void demonstrateLambdaModifyingStatic() {
        MyInterface myLambda = () -> {
            z = 10;
            return "Hello World";
        };

        System.out.println(myLambda.sayHello());
        System.out.println("Value of z: " + z);
        System.out.println("=====================");
    }

    // Demonstrating Java 8 Predicate usage
    private static void demonstratePredicate() {
        Predicate<Integer> isAdult = x -> x > 18;
        if (isAdult.test(25)) {
            System.out.println("You are adult");
        }

        Predicate<Integer> isEven = x -> x % 2 == 0;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,24,7,8,10);
        list.stream().filter(isEven).forEach(i -> System.out.print(i + ",  "));
        System.out.println("\n============================");

        Predicate<String> startsWithH = x -> x.toLowerCase().startsWith("h");
        Predicate<String> endsWithH = x -> x.toLowerCase().endsWith("h");
        System.out.println(startsWithH.test("Harsh"));
        System.out.println(startsWithH.and(endsWithH).test("HaRsh"));

        Function<String, Integer> len = x -> x.length();
        Function<String, String> sub = x -> x.substring(3);

        System.out.println(len.apply("Om Namah Shivaya"));
        System.out.println(sub.apply("Om Namah Shivaya"));

        Consumer<String> print = x -> System.out.println(x);
        print.accept("Sita Ram");
    }

    // Demonstrating BiPredicate usage
    private static void demonstrateBiPredicate() {
        BiPredicate<Integer, Integer> bothEven = (x, y) -> x % 2 == 0 && y % 2 == 0;
        System.out.println(bothEven.test(4, 6));

        BiPredicate<String, Integer> matchLength = (str, len) -> str.length() == len;
        System.out.println(matchLength.test("Om Namo Narayanaya", 18));
    }

    // Demonstrating BiFunction, Function, UnaryOperator, and BinaryOperator
    private static void demonstrateFunctions() {
        BiFunction<Integer, String, Integer> totalLength = (x, y) -> x + y.length();
        System.out.println(totalLength.apply(7, "Hanuman"));

        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(4));

        UnaryOperator<Integer> sq = x -> x * x;
        System.out.println(sq.apply(2));

        BinaryOperator<String> concat = (x, y) -> x + " " + y;
        System.out.println(concat.apply("Hare", "Krishna"));
    }

    // Imperative vs Stream approach for summing even numbers
    private static void demonstrateImperativeVsStream() {
        int[] arr = {1,2,4,5,7,8,9,6};

        // Imperative approach
        int sum = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("Sum using loop: " + sum);

        // Stream approach
        int streamSum = Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .sum();
        System.out.println("Sum using stream: " + streamSum);

        // Demonstrating basic stream
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 45, 6765, 5, 6, 65, 7, 23, 6543, 45, 23345, 56, 34, 54);
        System.out.println("Numbers greater than 50:");
        stream.filter(n -> n > 50).forEach(System.out::println);
        System.out.println("=========================");
    }
}
