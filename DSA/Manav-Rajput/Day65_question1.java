class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Create an array of pairs (position, time to reach the target)
        double[][] cars = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        // Sort the cars by their starting positions in descending order
        Arrays.sort(cars, Comparator.comparingDouble(a -> -a[0]));
        
        int fleets = 0;
        double currentFleetTime = 0;
        
        // Count the number of fleets
        for (int i = 0; i < n; i++) {
            if (cars[i][1] > currentFleetTime) {
                // A new fleet is formed
                fleets++;
                currentFleetTime = cars[i][1];
            }
        }
        
        return fleets;
    }
}
