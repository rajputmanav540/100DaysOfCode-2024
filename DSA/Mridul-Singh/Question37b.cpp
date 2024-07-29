//GFG Question -> K-Pangrams
// Given a string str and an integer k, return true if the string can be changed into a pangram after at most k operations, else return false.
// A single operation consists of swapping an existing alphabetic character with any other lowercase alphabetic character.
// Note - A pangram is a sentence containing every letter in the english alphabet.

#include<bits/stdc++.h>
using namespace std;

bool kPangram(string str, int k) {     //time complexity O(n) and space complexity O(1)
    int n=str.size();
    if(n<26)return false;
    vector<bool> alpha(26, false);
    int charCount=0;
    for (int i = 0; i < n; i++) {
        if (isalpha(str[i])){
            charCount++;
            alpha[tolower(str[i]) - 'a'] = true;
        }
    }
    if(charCount<26){
        return false;
    }
    int missingCount=0;
    for(int i=0;i<alpha.size();i++){
        if(!alpha[i]) missingCount++;
    }
    return(missingCount<=k);
}

int main(){
    cout << kPangram("jhwbdjwcbakjcbajbchabscyubakhaiu",3);
    return 0;
}