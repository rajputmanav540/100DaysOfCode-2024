class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Find the maximum number of bananas in any pile
        int maxBananas = 0;
        for (int pile : piles) {
            maxBananas = Math.max(maxBananas, pile);
        }
        int left = 1;
        int right = maxBananas;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canFinish(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            // Calculate hours needed to finish each pile at the current speed
            hoursNeeded += (pile + speed - 1) / speed; // Equivalent to Math.ceil(pile / speed)
        }
        return hoursNeeded <= h;
    }
}
