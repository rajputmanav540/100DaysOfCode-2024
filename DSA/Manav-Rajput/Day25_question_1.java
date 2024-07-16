class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i : nums) {
            if (i != val) {
                count++;
            }
        }
        int[] nums_new = new int[count];
        int index = 0;
        for (int i : nums) {
            if (i != val) {
                nums_new[index++] = i;
            }
        }
        for (int i = 0; i < nums_new.length; i++) {
            nums[i] = nums_new[i];
        }

        return count;
    }
}
