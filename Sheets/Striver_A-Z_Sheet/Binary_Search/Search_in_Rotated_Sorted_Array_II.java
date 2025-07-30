public class Search_in_Rotated_Sorted_Array_II {
    
}
/*
 * 81. Search in Rotated Sorted Array II
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
 

Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int low= 0;
        int high= nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            
            //if mid ele is target
            if(nums[mid]==target){
                return true;
            }

            if(nums[mid]==nums[low] && nums[low]==nums[high]){
                low++;
                high--;
                continue;
            }

            //if left half is sorted
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high= mid-1;
                }
                else{
                    low = mid+1;
                }
            }

            //if right half is sorted
            else{
                if(target>nums[mid] && target<=nums[high]){
                    low= mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}