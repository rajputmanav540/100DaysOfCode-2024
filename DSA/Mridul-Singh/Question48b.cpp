//GFG QUESTION -> Sorted matrix
//Given an NxN matrix Mat. Sort all elements of the matrix.

#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> sortedMatrix(int N, vector<vector<int>> Mat) {  //time compleixty O(n2 log n) and space complexity O(n2)
    // code here
    vector<int> arr;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            arr.push_back(Mat[i][j]);
        }
    }
    sort(arr.begin(), arr.end());
    int x = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            Mat[i][j] = arr[x++];
        }
    }
    return Mat;
}

int main(){
    vector<vector<int>> arr = {
        {0, 1, 1, 1},
        {0, 0, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}
    };  
    vector<vector<int>> sortedMat = sortedMatrix(4, arr);
    for(int i = 0; i < sortedMat.size(); i++) {
        for(int j = 0; j < sortedMat[i].size(); j++) {
            cout << sortedMat[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}