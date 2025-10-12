import java.util.*;
/*
 * 3713. Longest Balanced Substring I
Solved
Medium
premium lock icon
Companies
Hint
You are given a string s consisting of lowercase English letters.

A substring of s is called balanced if all distinct characters in the substring appear the same number of times.

Return the length of the longest balanced substring of s.

 

Example 1:

Input: s = "abbac"

Output: 4

Explanation:

The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.

Example 2:

Input: s = "zzabccy"

Output: 4

Explanation:

The longest balanced substring is "zabc" because the distinct characters 'z', 'a', 'b', and 'c' each appear exactly 1 time.​​​​​​​

Example 3:

Input: s = "aba"

Output: 2

Explanation:

​​​​​​​One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".

 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
 */
public class Longest_Balanced_Substring_I {
    class Solution {
        public boolean isBalanced(int[] freq, int tar) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0 && freq[i] != tar)
                    return false;
            }
            return true;
        }
        public int longestBalanced(String s) {
            int n = s.length();
            int ans = 0;

            for (int i = 0; i < n; i++) {
                int[] freq = new int[26];
                for (int j = i; j < n; j++) {
                    freq[s.charAt(j) - 'a']++;
                    if (isBalanced(freq, freq[s.charAt(j) - 'a'])) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }
            return ans;
        }

    }
}
