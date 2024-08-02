import java.util.Scanner;

public class Day42_Q2 {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int empty = 0;
        int result = 0;
        int idx1 = -1, idx2 = -1;
        
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                empty = 0;
                if (idx1 == -1) idx1 = i;
                idx2 = i;
            } else {
                empty++;
                result = Math.max(result, (empty + 1) / 2);
            }
        }
        result = Math.max(result, Math.max(idx1, n - 1 - idx2));
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of seats: ");
        int n = scanner.nextInt();
        int[] seats = new int[n];

        System.out.println("Enter the seat arrangement (0 for empty, 1 for occupied):");
        for (int i = 0; i < n; i++) {
            seats[i] = scanner.nextInt();
        }
        scanner.close();

        Day42_Q2 solution = new Day42_Q2();
        int result = solution.maxDistToClosest(seats);
        System.out.println("The maximum distance to the closest person is: " + result);
    }
}
