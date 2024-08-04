import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.Scanner;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int T = sc.nextInt(); // Number of test cases

            while (T-- > 0) {
                int N = sc.nextInt();
                int M = sc.nextInt();
                int nimSumAlice = 0;
                for (int i = 0; i < N; i++) {
                    nimSumAlice ^= sc.nextInt();
                }
                int nimSumBob = 0;
                for (int i = 0; i < M; i++) {
                    nimSumBob ^= sc.nextInt();
                }
                if (nimSumAlice != 0) {
                    System.out.println("Alice");
                } else {
                    if (nimSumBob != 0) {
                        System.out.println("Alice");
                    } else {
                        System.out.println("Bob");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            sc.close(); 
        }
    }
}
