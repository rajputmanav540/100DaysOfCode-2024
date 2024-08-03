class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int ans{}, count{};
        bool isFound{false};
        for(int i{}; i < (int)seats.size(); ++i){
            if(seats[i] == 0)
                ++count;
            else if(seats[i] == 1){
                if(isFound)
                    ans = max(ans, (count + 1) / 2);
                else
                    ans = max(ans, count);
                isFound = true;
                count = 0;
            }
        }
        if(count)
            ans = max(ans, count);
        return ans;
    }
};
