import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by jagod on 06/12/2016.
 */
public class Day1 {
    public static void main(String[] args) {
        new Day1().solution();
    }

    final String[] elvesInstruction = {"R4", "R4", "L1", "R3", "L5", "R2", "R5", "R1", "L4", "R3", "L5", "R2", "L3", "L4",
                               "L3", "R1", "R5", "R1", "L3", "L1", "R3", "L1", "R2", "R2", "L2", "R5", "L3", "L4",
                               "R4", "R4", "R2", "L4", "L1", "R5", "L1", "L4", "R4", "L1", "R1", "L2", "R5", "L2",
                               "L3", "R2", "R1", "L194", "R2", "L4", "R49", "R1", "R3", "L5", "L4", "L1", "R4",
                               "R2", "R1", "L5", "R3", "L5", "L4", "R4", "R4", "L2", "L3", "R78", "L5", "R4", "R191",
                               "R4", "R3", "R1", "L2", "R1", "R3", "L1", "R3", "R4", "R2", "L2", "R1", "R4", "L5", "R2",
                               "L2", "L4", "L2", "R1", "R2", "L3", "R5", "R2", "L3", "L3", "R3", "L1", "L1", "R5", "L4",
                               "L4", "L2", "R5", "R1", "R4", "L3", "L5", "L4", "R5", "L4", "R5", "R4", "L3", "L2", "L5",
                               "R4", "R3", "L3", "R1", "L5", "R5", "R1", "L3", "R2", "L5", "R5", "L3", "R1", "R4", "L5",
                               "R4", "R2", "R3", "L4", "L5", "R3", "R4", "L5", "L5", "R4", "L4", "L4", "R1", "R5", "R3",
                               "L1", "L4", "L3", "L4", "R1", "L5", "L1", "R2", "R2", "R4", "R4", "L5", "R4", "R1", "L1",
                               "L1", "L3", "L5", "L2", "R4", "L3", "L5", "L4", "L1", "R3"};

    IntVector2 easterBunnyLoc = new IntVector2(0,0);

    Direction currentDirection = Direction.NORTH;

    private void solution() {
        Stream.of(elvesInstruction)
                .map(this::stepToVector2)
                .reduce(IntVector2::combine)
                .ifPresent(intVector2 -> System.out.println("Result: " + intVector2.getDistance()));
    }

//    public Stream<String> streamWalk(String step) {
//        if (step != null) {
//            return Stream.of(step);
//        } else {
//            return s3Client
//                    .listDirectory(step)
//                    .stream()
//                    .flatMap(this::streamWalk);
//        }
//    }

    private void solutionRecursive() {
        Stream.of(elvesInstruction)
                .map(this::stepToVector2)
                .reduce(IntVector2::combine)
                .ifPresent(intVector2 -> System.out.println("Result: " + intVector2.getDistance()));
    }

    Set<IntVector2> positions = new HashSet<>();

    private void addPositions(IntVector2 vector) {
        if (vector.x == 0) {
            while (vector.y-- < 0) {

            }
        }
    }

    private IntVector2 stepToVector2(final String s) {

        int stepVal = Integer.parseInt(s.substring(1));
        this.currentDirection = updateDirection(this.currentDirection, s.charAt(0));

        switch (currentDirection) {
            case NORTH: return new IntVector2(0,stepVal);
            case EAST: return new IntVector2(stepVal, 0);
            case SOUTH: return new IntVector2(0, -1 * stepVal);
            case WEST: return new IntVector2( -1 * stepVal, 0);
        }
        throw new EnumConstantNotPresentException(Direction.class, "not present");
    }

    private Direction updateDirection(Direction currentDirection, char c) {
        if (c == 'R')
            return currentDirection.rotateRight(currentDirection); //oh God, so ugly here
        else
            return currentDirection.rotateLeft(currentDirection);
    }

    private class IntVector2 {
        public int x;
        public int y;

        public IntVector2(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public IntVector2 combine(IntVector2 otherVector) {
            return new IntVector2(this.x + otherVector.x, this.y + otherVector.y);
        }
        public int getDistance() {
            return Math.abs(x) + Math.abs(y);
        }
    }

    private enum Direction { NORTH, EAST, SOUTH, WEST;

        public Direction rotateLeft(Direction dir) {
            switch (dir) {
                case NORTH: return WEST;
                case WEST:  return SOUTH;
                case SOUTH: return EAST;
                case EAST:  return NORTH;
            }
            throw new EnumConstantNotPresentException(Direction.class, "not present");
        }

        public Direction rotateRight(Direction dir) {
            switch (dir) {
                case NORTH: return EAST;
                case EAST:  return SOUTH;
                case SOUTH: return WEST;
                case WEST:  return NORTH;
            }
            throw new EnumConstantNotPresentException(Direction.class, "not present");
        }
    }
}
