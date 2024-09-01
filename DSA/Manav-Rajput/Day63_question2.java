class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int balance = gas[i] - cost[i];
            totalTank += balance;
            currentTank += balance;
            
            // If current tank balance is negative, move the start station
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }
        
        // If the total gas balance is negative, return -1, else return start station
        return totalTank >= 0 ? startStation : -1;
    }
}
