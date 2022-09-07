import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Pass Function, Predicate as parameter
public class BehaviorParametrization {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2,3,4,5,9,0,12,56);
        //pass even predicate as param
        li.stream().filter(x -> x%2 == 0);
        //pass odd predicate as param
        li.stream().filter(x -> x%2!=0);
        //pass is multiple of 3 as param predicate
        li.stream().filter(x -> x%3 == 0);

        //We are passing behavior as a parameter to the function.
        Predicate<Integer> predicateOnEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };
        Predicate<Integer> predicateOnOdd = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };
        Predicate<Integer> predicateOnMultiple3 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };
        System.out.println("Function on even predicate");
        filterAndPrint(li, predicateOnEven);
        System.out.println("\nFunction on odd predicate");
        filterAndPrint(li, predicateOnOdd);
        System.out.println("\nFunction on x3 predicate");
        filterAndPrint(li, predicateOnMultiple3);

        //get list of squared numbers
        List<Integer> res = li.stream().map(i -> i*i).collect(Collectors.toList());
        System.out.println("\n"+res);

        Function<Integer, Integer>  mappingFun = new Function<>() {
            @Override
            public Integer apply(Integer o) {
                return o*o;
            }
        };

        Function<Integer, Integer>  mappingCubesFun = new Function<>() {
            @Override
            public Integer apply(Integer o) {
                return o*o*o;
            }
        };
       // res = li.stream().map(mappingFun).collect(Collectors.toList());
        res = mapAndReturnList(li, mappingFun);
        System.out.println("\nsquares fun "+res);
        res = mapAndReturnList(li, mappingCubesFun);
        System.out.println("cubes fun "+res);
    }

    private static List<Integer> mapAndReturnList(List<Integer> list,
                                                  Function<Integer, Integer> func) {
        return list.stream().map(func).collect(Collectors.toList());
    }

    /**
     * Takes predicate as input and applies it to the filter.
     * @param lst
     * @param predicate
     */
    private static void filterAndPrint(List<Integer> lst,
                                       Predicate<Integer> predicate){
        lst.stream().filter(predicate).map(i -> i+" ").forEach(System.out::print);
    }



}
