import java.util.Arrays;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1,2,4,5,712,0,12,54,90, 87, 67);
        //Print all numbers:
        li.stream().forEach(System.out::println);

        //print even numbers
        li.stream().filter(i -> i%2 == 0)
                .forEach(System.out::println);

        List<String> strings = Arrays.asList("Spring", "API", "Micro",
                "C#", "SpringBoot", "Spring MVC");

        //print courses containing Spring.
        strings.stream().filter(str -> str.contains("Spring"))
                .forEach(System.out::println);

        //courses at least 4 letters long
        strings.stream().filter(str -> str.length()>3)
                .forEach(System.out::println);
    }
}
