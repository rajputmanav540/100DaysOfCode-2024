// File: Day26_Q2.java
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Day26_Q2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int y = target - nums[i];
            if (map.containsKey(y) && map.get(y) != i) {
                return new int[] {i, map.get(y)};
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Day26_Q2 solution = new Day26_Q2();
        // Test the twoSum method with a sample input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices of the two numbers are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two sum solution");
        }
    }
}
