import java.util.*;
public class Subsets_II {
    
}
/*
 * 90. Subsets II
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */

class Solution {
    public void helper(int index, int nums[], Set<List<Integer>> ans, List<Integer> curr){
        if(index == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        helper(index + 1, nums, ans, curr);
        curr.remove(curr.size() - 1);
        helper(index + 1, nums, ans, curr);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        helper(0, nums, ans, new ArrayList<>());

        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> curr : ans){
            list.add(new ArrayList<>(curr));
        }

        return list;
    }
}
