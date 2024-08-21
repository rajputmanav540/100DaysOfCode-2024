#include <stdio.h>

double findMedianSortedArrays(int* a, int aSize, int* b, int bSize) {
    int n1 = aSize, n2 = bSize;
    int i = 0;
    int j = 0;
    int n = (n1 + n2);
    int ind2 = n / 2;
    int ind1 = ind2 - 1;
    int cnt = 0;
    int ind1el = -1, ind2el = -1;
    while (i < n1 && j < n2) {
        if (a[i] < b[j]) {
            if (cnt == ind1) {
                ind1el = a[i];
            }
            if (cnt == ind2) {
                ind2el = a[i];
            }
            cnt++;
            i++;
        } else {
            if (cnt == ind1) {
                ind1el = b[j];
            }
            if (cnt == ind2) {
                ind2el = b[j];
            }
            cnt++;
            j++;
        }
    }

    while (i < n1) {
        if (cnt == ind1) {
            ind1el = a[i];
        }
        if (cnt == ind2) {
            ind2el = a[i];
        }
        cnt++;
        i++;
    }

    while (j < n2) {
        if (cnt == ind1) {
            ind1el = b[j];
        }
        if (cnt == ind2) {
            ind2el = b[j];
        }
        cnt++;
        j++;
    }

    if (n % 2 == 1) {
        return (double)ind2el;
    }

    return (double)(ind1el + ind2el) / 2.0;
}

int main() {
    int a[] = {1, 3};
    int b[] = {2};
    int aSize = sizeof(a) / sizeof(a[0]);
    int bSize = sizeof(b) / sizeof(b[0]);

    printf("%f\n", findMedianSortedArrays(a, aSize, b, bSize));

    return 0;
}
