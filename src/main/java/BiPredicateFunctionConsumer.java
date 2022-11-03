import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicateFunctionConsumer {
    public static void main(String[] args) {
        //Bi-<> consumes two inputs(parameters)
        // Predicate -> BiPredicate
        // Function -> BiFunction
        // Consumer -> BiConsumer
        BiFunction<Integer, String, String> biFunction = (num, str) -> {
            System.out.println("BiFunction");
            return num + " " + str;
        };
        BiPredicate<Integer, String> biPredicate = (num, str) -> {
            return (num>10 && str.length()>10);
        };
        BiConsumer<Integer, String> biConsumer = (num, str) ->{
            System.out.print(num+", ");
            System.out.println(str);
        };
        biFunction.apply(10, "hello");
        biConsumer.accept(100, "biConsumer arg");
        System.out.println(biPredicate.test(11, "Hello world.."));
    }
}
