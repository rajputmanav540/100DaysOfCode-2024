public class Day50_Solution2 {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = getMax(piles);

            while(left <= right){
                int mid = left + (right - left) / 2;
                if(canEatInTime(piles, mid, h)) right = mid - 1;
                else left = mid + 1;
            }
            return left;
        }
        private int getMax(int[] piles) {
            int max = 0;
            for (int pile : piles) {
                if (pile > max) {
                    max = pile;
                }
            }
            return max;
        }
        public boolean canEatInTime(int piles[], int k, int h){
            int hours = 0;
            for(int pile : piles){
                int div = pile / k;
                hours += div;
                if(pile % k != 0) hours++;
            }
            return hours <= h;
        }
    }
