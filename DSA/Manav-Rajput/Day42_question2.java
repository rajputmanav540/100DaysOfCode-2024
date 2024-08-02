class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int maxDist = 0;
        int prevOccupied = -1;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (prevOccupied == -1) {
                    maxDist = i;
                } else {
                    maxDist = Math.max(maxDist, (i - prevOccupied) / 2);
                }
                prevOccupied = i;
            }
        }
        maxDist = Math.max(maxDist, n - 1 - prevOccupied);

        return maxDist;
    }
}
