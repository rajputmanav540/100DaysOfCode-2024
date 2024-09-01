//car fleet 
public class Day65_Q1 {
    public int carFleet(final int target, final int[] position, final int[] speed) {
        final int n = position.length;
        final double[] time = new double[target];

        for (int i = 0; i < n; ++i)
            time[position[i]] = (double) (target - position[i]) / speed[i];

        double prev = 0.0;
        int res = 0;

        for (int i = target - 1; i >= 0; --i) {
            final double cur = time[i];

            if (cur > prev) {
                prev = cur;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Day65_Q1 solution = new Day65_Q1();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        
        int result = solution.carFleet(target, position, speed);
        System.out.println("Number of car fleets: " + result);
    }
}
