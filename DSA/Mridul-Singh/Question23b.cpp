#include <iostream>
#include <cmath>
using namespace std;

class Solution {
public:
    double myPow(double x, int n) {   //Time complexity o(n) and Space o(1)
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            if (n == INT_MIN) {  // because negative no. are 2**31 and positive no. (2**31)-1
                return x * myPow(x, INT_MAX);  
            }
            n = -n;
        }
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
};

int main() {
    Solution solution;
    cout << solution.myPow(2.0, 10) << endl;
    cout << solution.myPow(2.1, 3) << endl;
    cout << solution.myPow(2.0, -2) << endl;
    return 0;
}
