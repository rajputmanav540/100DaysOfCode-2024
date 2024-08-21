// Find Median from Data Stream
import java.util.ArrayList;

public class Day52_Q1 {

    private ArrayList<Integer> arr;

    public Day52_Q1() {
        arr = new ArrayList<>();
    }

    public void addNum(int num) {
        int beg = 0;
        int end = arr.size();
        while (beg < end) {
            int mid = (end + beg) / 2;
            if (arr.get(mid) > num) {
                end = mid;
            } else {
                beg = mid + 1;
            }
        }
        arr.add(beg, num);
    }

    public double findMedian() {
        int n = arr.size();
        if (n % 2 == 1) {
            return arr.get(n / 2);
        } else {
            return (arr.get(n / 2 - 1) + arr.get(n / 2)) / 2.0;
        }
    }

    public static void main(String[] args) {
        Day52_Q1 mf = new Day52_Q1();
        mf.addNum(1);
        System.out.println(mf.findMedian()); // Output: 1.0
        mf.addNum(2);
        System.out.println(mf.findMedian()); // Output: 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // Output: 2.0
        mf.addNum(4);
        System.out.println(mf.findMedian()); // Output: 2.5
    }
}
