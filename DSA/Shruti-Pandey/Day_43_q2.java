class Solution {
    public int numTimesAllBlue(int[] flips) {
        int moves=0;
        int right = 0; 
        for(int i=0; i<flips.length; i++){
            right = Math.max(right, flips[i]);
            if(right == i+1){
                moves++;
            }
        }
        return moves;
    }
}
