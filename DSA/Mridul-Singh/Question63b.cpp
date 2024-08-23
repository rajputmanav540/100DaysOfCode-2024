//LEETCODE PROBLEM 134

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int sumCost = accumulate(cost.begin(), cost.end(), 0);
        int sumGas = accumulate(gas.begin(), gas.end(), 0);
        if (sumCost > sumGas) {
            return -1;
        }
        int currentGas = 0;
        int startingIndex = 0;
        for (int i = 0; i < gas.size(); i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startingIndex = i + 1;
            }
        }
        return startingIndex;
    }
};

int main() {
    Solution solution;
    vector<int> gas1 = {1, 2, 3, 4, 5};
    vector<int> cost1 = {3, 4, 5, 1, 2};
    int result1 = solution.canCompleteCircuit(gas1, cost1);
    cout << "Starting index for test case 1: " << result1 << endl;
    vector<int> gas2 = {2, 3, 4};
    vector<int> cost2 = {3, 4, 3};
    int result2 = solution.canCompleteCircuit(gas2, cost2);
    cout << "Starting index for test case 2: " << result2 << endl;
    return 0;
}
