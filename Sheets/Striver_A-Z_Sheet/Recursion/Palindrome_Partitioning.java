import java.util.*;

public class Palindrome_Partitioning {
    
}
/*
 * 131. Palindrome Partitioning
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 */

class Solution {
    public void store(int index, String str, List<List<String>> ans, List<String> curr){
        if(index==str.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<str.length();i++){
            if(isPalindrome(str, index, i)){
                curr.add(str.substring(index, i+1));
                store(i+1, str, ans, curr);
                curr.remove(curr.size()-1);
            }
        }

    }
    public boolean isPalindrome(String str, int start, int end){
        while(start<=end){
            if(str.charAt(start++)!=str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> curr= new ArrayList<>();
        store(0, s, ans, curr);
        return ans;
    }
}