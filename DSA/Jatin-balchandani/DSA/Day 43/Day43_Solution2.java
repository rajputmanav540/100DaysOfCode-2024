public class Day43_Solution2 {
        public int numTimesAllBlue(int[] flips) {
            // taking the count of left side is ALL SETBIT
            int moves=0;

            //right most setBit
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

