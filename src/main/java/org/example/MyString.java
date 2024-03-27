package org.example;

public class MyString {
    // Define a method to find the index of the first occurrence of one string (s2) in another (s1) starting from a given position (pos)
    public int indexOfString(String s1, String s2, int pos) {
        // Check for null strings, empty strings, or negative starting positions
        // Return -1 if any of these conditions are true, as the search is invalid
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() || pos < 0) {
            return -1;
        }

        // Iterate over the first string, starting from the position 'pos'
        // Continue as long as there is room for s2 to fit in the remaining part of s1
        for (int i = pos; i <= s1.length() - s2.length(); i++) {
            int j;
            // Iterate over the second string (s2)
            for (j = 0; j < s2.length(); j++) {
                // If the current character in s1 does not match the corresponding character in s2, break out of the inner loop
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }
            // If the inner loop completes, which means j reaches the length of s2,
            // then all characters in s2 matched in s1 starting at index i
            // Hence, return the starting index i where the match is found
            if (j == s2.length()) {
                return i;
            }
        }
        // If no match is found after completing the loop, return -1
        return -1;
    }
}
