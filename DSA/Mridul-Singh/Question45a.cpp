// LEETCODE PROBELM 925
// Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
// You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
// Example 1:
// Input: name = "alex", typed = "aaleex"
// Output: true
// Explanation: 'a' and 'e' in 'alex' were long pressed.

#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    bool isLongPressedName(string name, string typed) {     //time complexity O(n) and space complexity O(1)
        int i = 0, j = 0;
        while (j < typed.size()) {
            if (i < name.size() && name[i] == typed[j]) {
                i++;
            } else if (j == 0 || typed[j] != typed[j - 1]) {
                return false;
            }
            j++;
        }
        return i == name.size();
    }
};

int main() {
    Solution solution;
    string name1 = "alex";
    string typed1 = "aaleex";
    cout << (solution.isLongPressedName(name1, typed1) ? "true" : "false") << endl;
    string name2 = "saeed";
    string typed2 = "ssaaedd";
    cout << (solution.isLongPressedName(name2, typed2) ? "true" : "false") << endl;
    return 0;
}
