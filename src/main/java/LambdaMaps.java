import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaMaps {
    private static int sum(int a, int b){
        return a+b;
    }
    public static void main(String[] args) {
        //squares of even numbers
        List<Integer> testdata1 =
                Arrays.asList(1, 2,3,3,4,56,7,89,45,21,54,7,23,87);
        testdata1.stream().filter(i -> i%2 == 0)
                .map(i -> i*i).forEach(System.out::println);
        List<String> strings = Arrays.asList("Spring", "API", "Micro",
                "C#", "SpringBoot", "Spring MVC");
        //Print number of characters
        strings.stream().map(i-> i.length()).forEach(System.out::println);

        int sumOfNums = testdata1.stream().reduce(0, LambdaMaps::sum);
        System.out.println("sum = "+sumOfNums);
        //or
        sumOfNums = testdata1.stream().reduce(0, (a,b) -> a+b);
        System.out.println("sum = "+sumOfNums);
        sumOfNums = testdata1.stream().reduce(0,Integer::sum);

        //get max of list
        System.out.println("Max "+
        testdata1.stream().reduce(0, (a,b) -> a>b?a:b)
        );

        //Square every number in list and find sum of squares
        System.out.println("sum of all squares= "+
        testdata1.stream().map(i -> i*i).reduce(0, (a,b) -> a+b)
        );

        //sum of odd numbers
        System.out.println("sum of all odds = "
            + testdata1.stream().filter(i -> i%2 == 1).reduce(0, (a,b) -> a+b)
        );

        //---------OPERATORS----------
        //DISTINCT:
        System.out.println("Distinct elements: ");
        testdata1.stream().distinct().forEach(System.out::println);

        //SORTED
        System.out.println("Sorted - natural order");
        testdata1.stream().sorted().map(i -> i+" ").forEach(System.out::print);

        System.out.println("Sorted - reverse order");
        testdata1.stream().sorted(Comparator.reverseOrder()).map(i -> i+" ").forEach(System.out::print);

        System.out.println("Sorted - reversed sort by length");
        strings.stream().sorted(Comparator.comparing(String::length).reversed()).
                forEach(System.out::println);

        /*
            filter, distinct, sorted, map are intermediate operations
            forEach, collect are terminal operations.
         */
    }
}
