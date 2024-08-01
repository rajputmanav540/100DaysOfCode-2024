public class Day41_Solution1 {
        public boolean validPalindrome(String s) {
            int l =0;
            int r = s.length() -1;

            while(l < r){
                if(s.charAt(l) == s.charAt(r)){
                    l++;
                    r--;
                }
                else{
                    if(isPalindrome(s, l+1, r)){
                        return true;
                    }
                    if(isPalindrome(s, l, r-1)){
                        return true;
                    }
                    return false;

                }
            }
            return true;
        }
        boolean isPalindrome(String s, int left, int right){
            while(left< right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left++;
                right--;


            }
            return true;
        }
    }


