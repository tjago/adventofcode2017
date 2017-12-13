import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by jagod on 11/12/2016.
 */
public class Day2 {

    private static final String TEXT_FILE_LOCATION = "src/Day2Puzzle.txt";

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        day2.solution(day2.loadInstruction());
    }

    private void solution(char[] instructionLines) {

    }

    private void calcNumber(int startNum) {

    }

    char[] loadInstruction() {

        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(TEXT_FILE_LOCATION), StandardCharsets.UTF_8)) {

            reader.lines()
                    .flatMap(s -> s.toCharArray())
                    .map(this::convertToDirection)
                    .forEach(System.out::println);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Step convertToDirection(char c) {
        switch (c) {
            case 'U': return new Step(Direction.UP);
            case 'D': return new Step(Direction.DOWN);
            case 'L': return new Step(Direction.LEFT);
            case 'R': return new Step(Direction.RIGHT);
            default: throw new EnumConstantNotPresentException(Direction.class, "Direction not present");
        }
    }

    private enum Direction {UP, DOWN, LEFT, RIGHT}

    private class Step {
        Direction direction;

        Step(Direction direction) {
            this.direction = direction;
        }
    }
}
