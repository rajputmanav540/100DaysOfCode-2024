//LEETCODE PROBLEM 853

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    struct node{
        int pos;
        float time;
    };
    
    static bool compare(struct node &a, struct node &b){
        if(a.pos == b.pos) return a.time > b.time;
        return a.pos < b.pos;
    }
    
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int n=position.size();
        vector<node> fleet;
        for(int i=0;i<n;i++){
            fleet.push_back({position[i], (target-position[i])/(float)speed[i]});
        }
        sort(fleet.begin(),fleet.end(),compare);
        int c=0;
        int i=n-1;
        while(i>=0){
            c++;
            float t=fleet[i].time;
            while(--i>=0 && fleet[i].time <= t) continue; 
        }
        return c;
    }
};

int main() {
    Solution solution;
    int target1 = 12;
    vector<int> position1 = {10, 8, 0, 5, 3};
    vector<int> speed1 = {2, 4, 1, 1, 3};
    int result1 = solution.carFleet(target1, position1, speed1);
    cout << "Number of car fleets = " << result1 << endl;
    return 0;
}