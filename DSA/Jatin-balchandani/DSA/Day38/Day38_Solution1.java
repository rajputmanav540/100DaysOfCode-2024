import java.util.*;
public class Day38_Solution1 {


        String removeDups(String str) {
            Set<Character> seen = new HashSet<>();
            StringBuilder result =  new StringBuilder();
            // code here
            for(char c : str.toCharArray()){
                if(!seen.contains(c)){
                    seen.add(c);
                    result.append(c);

                }

            }return result.toString();
        }
    }
