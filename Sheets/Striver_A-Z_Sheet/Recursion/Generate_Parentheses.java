import java.util.*;
public class Generate_Parentheses {
    
}
/*
 * 22. Generate Parentheses

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        helper(0,0,n,"",l);
        return l;
    }
    public void helper(int open, int close, int n, String curr, List<String>ans){
        if(curr.length()==n*2){
            ans.add(curr);
            return;
        }
        if(open<n){
            helper(open+1, close, n, curr+"(", ans);
        }
        if(close<open){
            helper(open, close+1, n, curr+")", ans);
        }

    }
    
}