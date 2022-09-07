import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionsPredicatesAndConsumers {
    public static void main(String[] args) {
        //Predicate -> returns true or false, single parameter. Input type <T>
        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2 == 0;
            }
        };

        //Function -> input type <T>, Return type <R>
        Function<Integer, Integer> square = new Function<Integer, Integer>(){
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };

        //Consumers -> accepts single input<T>. Returns void
        Consumer<Integer> printEach  = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        List<Integer> li = Arrays.asList(1, 3, 4, 5,6,2, 9);
        //Find  squares of evens in the list
        li.stream().filter(isEvenPredicate).map(square).forEach(printEach);

        //examples
        int sum = li.stream().reduce(0, Integer::sum);

        //or
        //BinaryOperator -> operates on TWO OPERANDS of same type and return type is also same.  <T>
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        //or
        binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x+y;
            }
        };
        sum = li.stream().reduce(0, binaryOperator);
        System.out.println("sum = " + sum);

    }

}
