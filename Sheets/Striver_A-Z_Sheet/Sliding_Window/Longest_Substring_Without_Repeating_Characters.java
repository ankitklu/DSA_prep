import java.util.*;
public class Longest_Substring_Without_Repeating_Characters {
    
}
/*
 * 3. Longest Substring Without Repeating Characters
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set= new HashSet<>();
        int right=0;
        int left=0;
        int maxLen= 0;
        int n=s.length();

        while(right<n){
            char curr= s.charAt(right);
            while(left<n && set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            maxLen= Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
