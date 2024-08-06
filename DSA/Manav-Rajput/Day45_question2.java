class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String smallest = s;
            String rotated = s;
            for (int i = 0; i < s.length(); i++) {
                rotated = rotated.substring(1) + rotated.charAt(0);
                if (rotated.compareTo(smallest) < 0) {
                    smallest = rotated;
                }
            }
            return smallest;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
