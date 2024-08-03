//kth smallest 
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day42_Q1 {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = l; i <= r; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        scanner.close();
        
        Day42_Q1 solution = new Day42_Q1();
        int result = solution.kthSmallest(arr, 0, n - 1, k);
        System.out.println("The " + k + "-th smallest element is: " + result);
    }
}
