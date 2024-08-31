// Gas Station

class Day63_Q2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumCost = 0;
        for (int c : cost) {
            sumCost += c;
        }
        int sumGas = 0;
        for (int g : gas) {
            sumGas += g;
        }
        // Check if it is possible to complete the journey
        if (sumCost > sumGas) {
            return -1;
        }

        int currentGas = 0;
        int startingIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startingIndex = i + 1;
            }
        }
        return startingIndex;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Example usage
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Day63_Q2 solution = new Day63_Q2();
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println("Starting index: " + result);
    }
}
