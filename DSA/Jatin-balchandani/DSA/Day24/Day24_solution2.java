public class Day24_solution2 {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Day24_solution2 solution = new Day24_solution2();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
