// Container With Most Water
public class Day46_Q1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(solution.maxArea(new int[] { 1, 1 }));
        System.out.println(solution.maxArea(new int[] { 4, 3, 2, 1, 4 }));
        System.out.println(solution.maxArea(new int[] { 1, 2, 1 }));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
