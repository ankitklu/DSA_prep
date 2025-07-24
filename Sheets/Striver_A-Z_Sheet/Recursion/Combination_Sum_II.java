import java.util.*;

public class Combination_Sum_II {
    
}
/*
 * 40. Combination Sum II
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */


class Solution {
    public void helper(int index, int target, int candidates[],List<List<Integer>> ans, List<Integer> curr){
            if(target==0){
                ans.add(new ArrayList<>(curr));
            }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            curr.add(candidates[i]);
            helper(i+1, target-candidates[i], candidates, ans, curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(candidates);  
        helper(0,target,candidates, ans, new ArrayList<>());
        return ans;
    }
}