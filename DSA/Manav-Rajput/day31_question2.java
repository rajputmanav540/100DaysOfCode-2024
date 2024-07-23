class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int total = 0;
        int start = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                count = i - start;
                total += count;
            } else if (nums[i] > right) {
                count = 0;
                start = i;
            } else {
                total += count;
            }
        }

        return total;
    }
}
