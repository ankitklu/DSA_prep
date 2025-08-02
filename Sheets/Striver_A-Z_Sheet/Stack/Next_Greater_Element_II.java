import java.util.*;

public class Next_Greater_Element_II {
    
}
/*
 * 503. Next Greater Element II

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
          Stack<Integer> st = new Stack<>();
          int ans[]= new int [n];

          for(int i =n-1;i>=0;i--){
            st.push(nums[i]);
          }

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&& nums[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            } 
            else{
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
}
