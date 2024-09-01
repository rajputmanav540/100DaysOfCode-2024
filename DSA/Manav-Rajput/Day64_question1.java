class Solution {
    public String removeDuplicateLetters(String s) {
        // Step 1: Initialize variables
        int[] frequency = new int[26];  // Frequency array for each character
        boolean[] visited = new boolean[26]; // To track characters already in the result
        char[] string = s.toCharArray(); // Convert the string to a character array

        // Step 2: Fill the frequency array with character counts
        for (char c : string) {
            frequency[c - 'a']++;
        }

        // Step 3: Use a StringBuilder as a stack to build the result
        StringBuilder result = new StringBuilder();

        // Step 4: Iterate over the characters in the string
        for (char c : string) {
            // Decrease the frequency of the current character
            frequency[c - 'a']--;

            // If the character is already in the result, skip it
            if (visited[c - 'a']) {
                continue;
            }

            // Remove characters from the result that are greater than the current character
            // and still have remaining frequency (i.e., can appear later)
            while (result.length() > 0 && result.charAt(result.length() - 1) > c && frequency[result.charAt(result.length() - 1) - 'a'] > 0) {
                visited[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            // Add the current character to the result and mark it as visited
            result.append(c);
            visited[c - 'a'] = true;
        }

        // Convert the result to a string and return it
        return result.toString();
    }
}
