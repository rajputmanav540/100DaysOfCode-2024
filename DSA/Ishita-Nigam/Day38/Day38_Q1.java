//Remove Duplicate 
import java.util.Scanner;

public class Day38_Q1 {
    public String removeDups(String str) {
        int N = str.length();
        int index = 0;
        char[] result = str.toCharArray();

        for (int i = 0; i < N; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (result[i] == result[j]) {
                    break;
                }
            }
            if (j == i) {
                result[index++] = result[i];
            }
        }

        return new String(result, 0, index);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        Day38_Q1 solution = new Day38_Q1();
        String result = solution.removeDups(str);
        System.out.println("String after removing duplicates: " + result);
    }
}
