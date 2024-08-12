class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Find the maximum weight in the array and the sum of all weights
        int maxWeight = 0;
        int totalWeight = 0;
        
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int left = maxWeight;
        int right = totalWeight;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        return left;
    }
    private boolean canShip(int[] weights, int days, int capacity) {
        int dayCount = 1;
        int currentLoad = 0;
        
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                dayCount++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        
        return dayCount <= days;
    }
}
