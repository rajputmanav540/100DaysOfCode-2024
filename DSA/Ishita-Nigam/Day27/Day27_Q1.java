//Majority Element
import java.util.Arrays;

public class Day27_Q1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }

    public static void main(String[] args) {
        Day27_Q1 solution = new Day27_Q1();
        int[] nums = { 3, 2, 3 };

        int result = solution.majorityElement(nums);
        System.out.println("The majority element is: " + result);
    }
}
