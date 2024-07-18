//Majority Element 2
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day27_Q2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = n / 3;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > a) list.add(key);
        }
        return list;
    }

    public static void main(String[] args) {
        Day27_Q2 solution = new Day27_Q2();
        int[] nums = {3, 2, 3, 1, 1, 1, 2, 2};

        List<Integer> result = solution.majorityElement(nums);
        System.out.println("The majority elements are: " + result);
    }
}
