class Solution {
  public:
    long long int findMaxProduct(vector<int>& arr) {
        int n = arr.size();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        int max_neg = INT_MIN;
        int count_neg = 0, count_zero = 0;
        long long product = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count_zero++;
                continue;
            }
            if (arr[i] < 0) {
                count_neg++;
                max_neg = max(max_neg, arr[i]);
            }
            product *= arr[i];
        }
        if (count_zero == n || (count_neg == n && count_zero > 0)) {
            return 0;
        }
        if (count_neg % 2 == 0) {
            return product;
        }
        product /= max_neg;
        return product;
    }
};
