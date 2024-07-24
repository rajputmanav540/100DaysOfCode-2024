public class Day33_Solution1 {

        public String printString(String s, char ch, int count) {
            // code here
            int occur = 0;

            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == ch){
                    occur++;
                }
                if(occur == count){
                    s.substring(i+1);

                }
            }
            return "";
        }
    }

