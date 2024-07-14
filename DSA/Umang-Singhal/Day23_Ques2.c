#include <stdio.h>
double myPow(double x, int n);
int main() {
    double x;
    int n;
    printf("Enter the base (x): ");
    scanf("%lf", &x);
    printf("Enter the exponent (n): ");
    scanf("%d", &n);
    double result = myPow(x, n);
    printf("%.5lf raised to the power of %d is: %.5lf\n", x, n, result);
    return 0;
}
double myPow(double x, int n) {
    if (n == 0) {
        return 1;
    }
    double result = 1.0;
    int absN = (n > 0) ? n : -n; 
    for (int i = 0; i < absN; i++) {
        result *= x;
    }
    if (n < 0) {
        result = 1.0 / result;
    }
    return result;
}
