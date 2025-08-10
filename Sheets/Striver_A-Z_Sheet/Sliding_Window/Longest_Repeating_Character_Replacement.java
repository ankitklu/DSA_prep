import java.util.*;

public class Longest_Repeating_Character_Replacement {
    
}
/*
 * 424. Longest Repeating Character Replacement
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */

class Solution {
    public int characterReplacement(String s, int k) {
        int right= 0;
        int left=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max= 0;
        int len=0;
        for(int i=0;i<s.length();i++){
            char curr= s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            max= Math.max(max, map.get(curr));
            if(right-left+1 -max >k){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            len= Math.max(len , right-left+1);
            right++;
        }
        return len;
    }
}
