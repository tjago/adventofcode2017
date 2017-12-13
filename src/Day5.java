import java.io.IOException;
import java.util.List;

/**
 * Created by jagod on 08/12/2017.
 */
public class Day5 {

    public static void main(String[] args) throws IOException {
        List<String> stringArray = new Day4().getStringArraysOutOfFile("res/Day5jumps.txt");
        int jumpArray[] = new int[stringArray.size()];
        int index = 0;
        for (String s : stringArray) {
            jumpArray[index++] = Integer.parseInt(s);
        }
        System.out.println("array size: " + jumpArray.length);

        long steps = 0;
        int i = 0;
        while (0 <= i && i < jumpArray.length) {
            i += jumpArray[i]++;
            steps++;
        }
        System.out.println("Steps taken: " + steps);

    }
}
