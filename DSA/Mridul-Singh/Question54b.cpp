//LEETCODE PROBLME -> 154. Find Minimum in Rotated Sorted Array II

#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int findMin(vector<int> &nums)      //time complexity O(log n) and space complexity O(1)
    {
        int low = 0, high = nums.size() - 1;
        int ans = nums[0];
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (low < nums.size() && high < nums.size())
            {
                if (nums[low] < nums[high])
                {
                    ans = min(ans, nums[low]);
                    break;
                }
                if (nums[low] == nums[mid])
                {
                    ans = min(ans, nums[low]);
                    low++;
                }
                else if (nums[low] <= nums[mid])
                {
                    ans = min(ans, nums[low]);
                    low = mid + 1;
                }
                else
                {
                    ans = min(ans, nums[mid]);
                    high = mid - 1;
                }
            }
            else
            {
                break;
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> arr={1,3,5};
    cout << s.findMin(arr);
    return 0;
}