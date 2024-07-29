class Solution {
    public boolean kPangram(String str, int k) {
        boolean[] present = new boolean[26];
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                present[ch - 'a'] = true;
            }
        }
        
        int additionalNeeded = 0;
        for (boolean isPresent : present) {
            if (!isPresent) {
                additionalNeeded++;
            }
        }
      
        return additionalNeeded <= k;
    }
}
