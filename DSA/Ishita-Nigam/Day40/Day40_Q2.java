
//Dominoes
import java.util.Scanner;

public class Day40_Q2 {
    public String pushDominoes(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char start = '.';
        char last = '.';
        int stidx = 0;
        int i = 0;
        while (i < n) {
            stidx = i;
            while (i < n && arr[i] == '.') {
                i++;
            }
            if (i < n) {
                last = arr[i];
            }
            if (i - stidx > 0) {
                if (start == 'R' && last == 'L') {
                    int l = stidx;
                    int r = i - 1;
                    while (l < r) {
                        arr[l] = 'R';
                        arr[r] = 'L';
                        l++;
                        r--;
                    }
                } else if (last == 'L') {
                    int l = i - 1;
                    while (l >= stidx) {
                        arr[l] = 'L';
                        l--;
                    }
                } else if (start == 'R') {
                    int r = stidx;
                    while (r < i) {
                        arr[r] = 'R';
                        r++;
                    }
                }
            }
            start = last;
            i++;
            last = '.';
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the dominoes string: ");
        String s = scanner.nextLine();
        scanner.close();

        Day40_Q2 solution = new Day40_Q2();
        String result = solution.pushDominoes(s);
        System.out.println("Resulting dominoes string: " + result);
    }
}
