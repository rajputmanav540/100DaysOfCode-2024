import java.util.HashMap;
import java.util.Map;

public class Day25_Solution2 {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Calculate the complement of the current number
            int complement = target - nums[i];
            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                // If found, return the indices of the complement and the current number
                return new int[]{map.get(complement), i};
            }
            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        // If no solution is found, return an empty array
        return new int[]{};
    }

    public static void main(String[] args) {
        Day25_Solution2 solution = new Day25_Solution2();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
