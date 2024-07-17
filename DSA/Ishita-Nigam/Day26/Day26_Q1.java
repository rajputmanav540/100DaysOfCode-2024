//Palindrome Number
public class Day26_Q1 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) (temp % 10);
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return (reversed == x);
    }

    public static void main(String[] args) {
        Day26_Q1 solution = new Day26_Q1();
        int testValue1 = 121;
        int testValue2 = -121;
        int testValue3 = 10;

        System.out.println(testValue1 + " is palindrome: " + solution.isPalindrome(testValue1));
        System.out.println(testValue2 + " is palindrome: " + solution.isPalindrome(testValue2));
        System.out.println(testValue3 + " is palindrome: " + solution.isPalindrome(testValue3));
    }
}
