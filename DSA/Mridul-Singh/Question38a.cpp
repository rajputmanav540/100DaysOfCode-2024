//GFG Question Remove Duplicates
// Given a string str without spaces, the task is to remove all duplicate characters from it, keeping only the first occurrence.
// Note: The original order of characters must be kept the same. 

#include<bits/stdc++.h>
using namespace std;

string removeDups(string str) {     //time complexity O(n) and space complexity O(1)
    string res="";
    int hash[256]={0};
    for(int i=0;i<str.size();i++){
        if(hash[str[i]]==false){
            res+=str[i];
            hash[str[i]]=true;
        }
    }
    return res;
}

int main(){
    cout <<removeDups("scnNASAsa");
    return 0;
}