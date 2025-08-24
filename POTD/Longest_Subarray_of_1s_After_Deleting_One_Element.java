/*
 * 1493. Longest Subarray of 1's After Deleting One Element
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */
public class Longest_Subarray_of_1s_After_Deleting_One_Element {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        int c=0;

        // while(right<nums.length && nums[right]==0){
        //     right++;
        // }
        // int k=1;

        while(right < nums.length){
            int curr =nums[right];
            if(curr==0){
                c++;;
            }
            while(c>1){
                if(nums[left]==0){
                    c--;
                }
                left++;
            }
            max= Math.max(max, right-left);
            right++;
        }
        return max;

    }
}