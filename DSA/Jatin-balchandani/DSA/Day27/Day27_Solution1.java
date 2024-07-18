import java.util.*;
public class Day27_Solution1 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            return nums[n/2];
        }

}
