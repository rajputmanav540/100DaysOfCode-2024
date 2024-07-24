public class Day33_Solution2 {


        public String smallestNumber(int s, int d) {
            // code here
            if(s>9*d || s==0 && d>1){
                return "-1";
            }
            char[] result = new char[d];
            for(int i=0;i<d;i++){
                result[i] = 0;
            }

            // Decrement sum by 1 to ensure the smallest number
            s -= 1;

            // Fill digits from the end to start
            for (int i = d - 1; i >= 0; i--) {
                if (s > 0) {
                    int digit = Math.min(9, s);
                    result[i] = (char) (digit + '0');
                    s -= digit;
                } else {
                    result[i] = '0';
                }
            }

            // Set the first digit to '1' (since we subtracted 1 from sum initially)
            result[0] = (char) (result[0] + 1);

            return new String(result);
        }
    }
