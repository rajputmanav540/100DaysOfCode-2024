import java.util.HashSet;

class Solution {
    public int majorityElement(int[] nums) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int[] count = new int[uniqueElements.size()];
        int index = 0;
        for (int num : uniqueElements) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == num) {
                    count[index]++;
                }
            }
            index++;
        }
        int majorityThreshold = nums.length / 2;
        int majorityElement = 0;
        index = 0;
        
        for (int num : uniqueElements) {
            if (count[index] > majorityThreshold) {
                majorityElement = num;
                break;
            }
            index++;
        }
        
        return majorityElement;
    }
}
