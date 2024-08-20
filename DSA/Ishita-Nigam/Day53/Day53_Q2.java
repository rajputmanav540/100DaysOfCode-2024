//Search in Rotated Sorted Array II
public class Day53_Q2 {

    public boolean search(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[s] == arr[mid] && arr[mid] == arr[e]) {
                s = s + 1;
                e = e - 1;
                continue;
            } else if (arr[s] <= arr[mid]) {
                if (arr[s] <= target && arr[mid] >= target) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (arr[e] >= target && target >= arr[mid]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Day53_Q2 solution = new Day53_Q2();
        int[] arr = {2, 5, 6, 0, 1, 2};
        int target = 0;
        boolean result = solution.search(arr, target);
        System.out.println("Target " + target + " found: " + result);
       
    }
}
