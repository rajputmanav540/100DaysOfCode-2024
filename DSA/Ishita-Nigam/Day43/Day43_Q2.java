public class Day43_Q2 {
    public int numTimesAllBlue(int[] flips) {
        // taking the count of left side is ALL SETBIT
        int moves = 0;

        // right most setBit
        int right = 0;

        for (int i = 0; i < flips.length; i++) {
            right = Math.max(right, flips[i]);
            if (right == i + 1) {
                moves++;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        Day43_Q2 solution = new Day43_Q2();
        int[] flips = {3, 2, 4, 1, 5}; // Example input
        int result = solution.numTimesAllBlue(flips);
        System.out.println("Number of times all bits are blue: " + result);
    }
}
