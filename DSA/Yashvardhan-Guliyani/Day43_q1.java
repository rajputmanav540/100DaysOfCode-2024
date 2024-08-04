import java.util.Scanner;
public class BuddyNimGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt(); 
            int[] A = new int[N];
            int[] B = new int[M];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }
            int nimSumA = 0;
            for (int num : A) {
                nimSumA ^= num;
            }
            int nimSumB = 0;
            for (int num : B) {
                nimSumB ^= num;
            }
            if (nimSumA != 0 || nimSumB == 0) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }
        sc.close();
    }
}
