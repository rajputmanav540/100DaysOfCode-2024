#include <stdio.h>
#include <stdlib.h>

int maxArea(int* height, int heightSize) {
    int res = 0;
    int l = 0, r = heightSize - 1;

    while (l < r) {
        int area = (r - l) * (height[l] < height[r] ? height[l] : height[r]);
        res = res > area ? res : area;

        if (height[l] < height[r]) {
            l += 1;
        } else {
            r -= 1;
        }
    }

    return res;
}

int main() {
    int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int heightSize = sizeof(height) / sizeof(height[0]);

    printf("%d\n", maxArea(height, heightSize));

    return 0;
}
