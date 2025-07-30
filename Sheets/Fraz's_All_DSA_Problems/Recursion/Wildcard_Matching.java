import java.util.*;

public class Wildcard_Matching {
    
}
/*
 * 44. Wildcard Matching
Solved

avatar
Discuss Approach
arrow-up
Hard
Topics
premium lock icon
Companies
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
 */

class Solution {
    public int helper(int[][] dp, int idx1, int idx2, String s, String p) {
        if (idx1 < 0 && idx2 < 0) return 1;
        if (idx2 < 0) return 0;
        if (idx1 < 0) return allStars(p, idx2) ? 1 : 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?') {
            return dp[idx1][idx2] = helper(dp, idx1 - 1, idx2 - 1, s, p);
        }

        if (p.charAt(idx2) == '*') {
            return dp[idx1][idx2] = (helper(dp, idx1 - 1, idx2, s, p) == 1 || helper(dp, idx1, idx2 - 1, s, p) == 1) ? 1 : 0;
        }

        return dp[idx1][idx2] = 0;
    }

    public boolean allStars(String p, int idx2) {
        for (int i = 0; i <= idx2; i++) {
            if (p.charAt(i) != '*') return false;
        }
        return true;
    }

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(dp, s.length() - 1, p.length() - 1, s, p) == 1;
    }
}
