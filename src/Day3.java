/* spiral memory
*
* Not working yet - Draft Stage..
*
* 17  16  15  14  13
* 18   5   4   3  12
* 19   6   1   2  11
* 20   7   8   9  10
* 21  22  23---> ...
*
* find number of steps required to reach position -> 325489 to center (1)
* */

public class Day3 {

    public static final int searchMemoryLocation = 325489;

    private MemoryPoint[] memoryArray;

    public static void main(String[] args) {

    }

    public MemoryPoint generateMemory() {
//        MemoryPoint[] memoryArray = new MemoryPoint[searchMemoryLocation];
//        MemoryPoint nextPos = calcNextPos(new MemoryPoint(0,0));
//        for(int i = 0; i < searchMemoryLocation; i++) {
//        }

        int b = 1;
        int maxX, maxY, minX, minY;
        int i,j;
        for (int x = 1; x < searchMemoryLocation; x++) {
//            if
        }

        for (int a = 0; a < 4; a++) {
            for (; b > 0; b--) {

            }
        }
        return null;
    }

//    private MemoryPoint calcNextPos(MemoryPoint memoryPoint) {
//        if (memoryPoint.equals(new MemoryPoint(0,0))) {
//            return new MemoryPoint(0,1);
//        }
//        else if (memoryArray[memoryPoint.pointToBottom()]){
//
//        }
//    }

    class MemoryPoint {
        public int posX, posY;

        public MemoryPoint(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
        }

        public MemoryPoint pointToLeft() {
            return new MemoryPoint(posX - 1, posY);
        }
        public MemoryPoint pointtoRight() {
            return new MemoryPoint(posX + 1, posY);
        }
        public MemoryPoint pointToTop() {
            return new MemoryPoint(posX, posY + 1);
        }
        public MemoryPoint pointToBottom() {
            return new MemoryPoint(posX, posY - 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MemoryPoint that = (MemoryPoint) o;

            if (posX != that.posX) return false;
            return posY == that.posY;
        }

        @Override
        public int hashCode() {
            int result = posX;
            result = 31 * result + posY;
            return result;
        }
    }
}