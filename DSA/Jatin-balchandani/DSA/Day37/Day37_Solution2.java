public class Day37_Solution2 {
        boolean kPangram(String str, int k) {
            // code here
            int count=0;
            if(str.replace(" ", "").length() < 26)
                return false;

            for(char i='a';i<='z';i++)
            {
                if(!str.contains(String.valueOf(i)))
                    count++;
            }
            if(count > k){
                return false;
            }
            return true;
        }
    
}
