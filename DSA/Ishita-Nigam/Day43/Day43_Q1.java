import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day43_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long sum1 = 0, sum2 = 0;
            int cnt1 = (int) n, cnt2 = (int) m;

            Long[] a = new Long[(int) n];
            Long[] b = new Long[(int) m];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                sum1 += a[i];
                if (a[i] == 0) {
                    cnt1--;
                }
            }

            for (int j = 0; j < m; j++) {
                b[j] = sc.nextLong();
                sum2 += b[j];
                if (b[j] == 0) {
                    cnt2--;
                }
            }

            Arrays.sort(a, Collections.reverseOrder());
            Arrays.sort(b, Collections.reverseOrder());

            n = cnt1;
            m = cnt2;

            if (n != m) {
                if (sum1 == sum2 && sum1 == 0) {
                    System.out.println("Bob");
                } else {
                    System.out.println("Alice");
                }
            } else {
                if (sum1 == sum2) {
                    boolean fl = false;
                    for (int i = 0; i < n; i++) {
                        if (!a[i].equals(b[i])) {
                            fl = true;
                            break;
                        }
                    }
                    if (fl) {
                        System.out.println("Alice");
                    } else {
                        System.out.println("Bob");
                    }
                } else {
                    System.out.println("Alice");
                }
            }
        }

        sc.close();
    }
}

