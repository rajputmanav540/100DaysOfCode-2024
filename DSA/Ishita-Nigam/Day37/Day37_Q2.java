
//K-pangrams
import java.util.Scanner;

public class Day37_Q2 {
    public boolean kPangram(String str, int k) {
        int n = str.length();
        if (n < 26)
            return false;

        boolean[] alpha = new boolean[26];
        int charCount = 0;

        for (int i = 0; i < n; i++) {
            if (Character.isLetter(str.charAt(i))) {
                charCount++;
                alpha[Character.toLowerCase(str.charAt(i)) - 'a'] = true;
            }
        }

        if (charCount < 26) {
            return false;
        }

        int missingCount = 0;
        for (boolean b : alpha) {
            if (!b)
                missingCount++;
        }

        return missingCount <= k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        scanner.close();

        Day37_Q2 solution = new Day37_Q2();
        boolean result = solution.kPangram(str, k);
        System.out.println("Is the string a k-pangram? " + result);
    }
}
