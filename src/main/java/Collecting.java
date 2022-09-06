import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collecting {
    private static List<Integer> getSquaresOfNums(List<Integer> list){
        return list.stream().map(i -> i*i).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        //get squares of all nums
        List<Integer> li = Arrays.asList(1, 2, 4, 4, 6, 67, 32, 6, 8, 0);
        System.out.println(getSquaresOfNums(li));

        //create list with even nums filtered from nums list
        System.out.println("even nums "+
                li.stream().filter(i -> i%2 == 0).collect(Collectors.toList())
                );
        List<String> strings = Arrays.asList("Spring", "API", "Micro",
                "C#", "SpringBoot", "Spring MVC");
        //create list with lengths of all strs from list
        System.out.println("Lengths: "+
                strings.stream().map(String::length).collect(Collectors.toList())
                );
    }
}
