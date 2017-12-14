import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day10 {

    public static final int [] lengthsInput = {165,1,255,31,87,52,24,113,0,91,148,254,158,2,73,153 };

    List knotList;

    public static void main(String[] args) {
        new Day10().run();
    }

    private void run() {
        List l = createList();
    }

    private List createList() {

        List<Integer> l = IntStream
                .iterate(0, n -> n + 1)
                .peek(System.out::println)
                .limit(256)
                .boxed()
                .collect(Collectors.toList());
        return l;
    }
}
