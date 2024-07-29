import java.util.Scanner;

public class Day36_Q2 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int len = tops.length;
        int min = Integer.MAX_VALUE;
        int[] arr = new int[2];
        
        arr[0] = tops[0];
        arr[1] = bottoms[0];
        
        for (int i = 0; i < 2; i++) {
            int topRot = 0;
            int bottomRot = 0;
            boolean flag = true;
            
            for (int j = 0; j < len; j++) {
                if (tops[j] == arr[i] || bottoms[j] == arr[i]) {
                    if (tops[j] != arr[i]) {
                        topRot++;
                    } else if (bottoms[j] != arr[i]) {
                        bottomRot++;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                min = Math.min(topRot, bottomRot);
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        
        int[] tops = new int[n];
        int[] bottoms = new int[n];
        
        System.out.println("Enter the tops array:");
        for (int i = 0; i < n; i++) {
            tops[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the bottoms array:");
        for (int i = 0; i < n; i++) {
            bottoms[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        Day36_Q2 solution = new Day36_Q2();
        int result = solution.minDominoRotations(tops, bottoms);
        System.out.println("Minimum number of rotations: " + result);
    }
}
