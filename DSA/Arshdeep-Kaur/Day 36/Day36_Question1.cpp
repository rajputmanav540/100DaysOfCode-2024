class Solution {
public:
    int maximumSwap(int num) {
        int lastIndex[10];
        string temp = to_string(num);
        for(int i=0; i<temp.length(); i++) {
            int digit = temp[i] - '0';
            lastIndex[digit] = i;
        }

        bool flag = false;
        for(int i=0; i<temp.length(); i++) {
            int digit = temp[i] - '0';
            for(int j=9; j>digit; j--) {
                if (lastIndex[j] > i) {
                    swap(temp[i], temp[lastIndex[j]]);
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                break;
            }
        }

        int result = stoi(temp);
        return result;
    }
};
