//Sort Array By Parity
class Day34_Q1 {
    public static class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] % 2 == 0) { // If nums[i] is even, increment i.
                    i++;
                } else if (nums[j] % 2 != 0) { // If nums[j] is odd, decrement j.
                    j--;
                } else { // If nums[i] is odd and nums[j] is even, swap them and update pointers.
                    swap(nums, i, j);
                    i++;
                    j--;
                }
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 3, 1, 2, 4 };
        int[] sorted = sol.sortArrayByParity(nums);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}
