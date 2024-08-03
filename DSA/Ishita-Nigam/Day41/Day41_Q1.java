
//valid palindrome 2
import java.util.Scanner;

public class Day41_Q1 {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        scanner.close();

        Day41_Q1 solution = new Day41_Q1();
        boolean result = solution.validPalindrome(s);
        System.out.println("Is the string a valid palindrome with at most one character deletion? " + result);
    }
}
