class Solution {
public:
    int fib(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        int a=0, b=1, count=0, nextTerm;
        while(count <= n-2) {
            nextTerm = a+b;
            a = b;
            b = nextTerm;
            count++;
        }
        return nextTerm;
    }
};
