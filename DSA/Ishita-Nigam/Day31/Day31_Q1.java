//Product of Array Except Self
public class Day31_Q1 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int pro = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    pro *= nums[j];
                }
            }
            result[i] = pro;
        }
        return result;
    }

    public static void main(String[] args) {
        Day31_Q1 solution = new Day31_Q1();
        int[] nums = { 1, 2, 3, 4 };
        int[] result = solution.productExceptSelf(nums);
        System.out.print("Product of array except self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
