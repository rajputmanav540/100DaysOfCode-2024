#include <stdio.h>

int maximumSwap(int num) {
    char num_str[10];
    sprintf(num_str, "%d", num);
    int max_idx = 0;
    int max_val = num_str[0];
    int swap_idx1 = 0, swap_idx2 = 0;

    for (int i = 1; i < strlen(num_str); i++) {
        if (num_str[i] > max_val) {
            max_val = num_str[i];
            max_idx = i;
        }
    }
    for (int i = 0; i < max_idx; i++) {
        if (num_str[i] < max_val) {
            swap_idx1 = i;
            break;
        }
    }
    if (swap_idx1 == 0 && num_str[0] == max_val) {
        return num;
    }

    for (int i = strlen(num_str) - 1; i >= max_idx; i--) {
        if (num_str[i] == max_val) {
            swap_idx2 = i;
            break;
        }
    }

    char temp = num_str[swap_idx1];
    num_str[swap_idx1] = num_str[swap_idx2];
    num_str[swap_idx2] = temp;

    int result = atoi(num_str);
    return result;
}

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);
    printf("Maximum valued number: %d\n", maximumSwap(num));
    return 0;
}
