class Solution {
    String removeDups(String str) {
        HashSet<Character> seen = new HashSet<>();
       
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
