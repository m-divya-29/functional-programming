import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Problems {
    public static void main(String[] args) {
        //#1: Given a list of numbers, find min, max and sum using a single stream.
        List<Integer> li = Arrays.asList(1,3,4,5,67,9);
        IntSummaryStatistics statistics = li.stream().collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine);
        System.out.println("min: "+statistics.getMin());
        System.out.println("max: "+statistics.getMax());
        System.out.println("sum: "+statistics.getSum());
    }
}
