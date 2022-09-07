import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class SuppliersAndUnaryOperator {
    public static void main(String[] args) {
        //return random number within 1000
        //Supplier -> no input, returns <T>
        Supplier<Integer> randomNumSupplier = () -> {
            Random rand = new Random();
            return rand.nextInt(1000);
        };

        //UnaryOperator -> Single input<T> returns <T>
        UnaryOperator<Integer> unaryOperator = (x) -> x*2;
        System.out.println(unaryOperator.apply(10));

        UnaryOperator<Integer> unaryOperator1 = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer+integer;
            }
        };
        System.out.println(unaryOperator1.apply(300));

    }
}
