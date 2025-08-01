/*
 * Split Array Largest Sum

avatar
Discuss Approach
arrow-up
Solved
Hard
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
 */

class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE;
        int high= 0;
        for(int num: nums){
            low = Math.max(num, low);
            high += num;
        }
        int min= low;
        while(low<=high){
            int mid = (high+low)/2;
            if(isPossible(nums, mid, k)){
                min = mid;
                high= mid-1;
            }
            else{
                low= mid+1;
            }   
        }
        return min;
    }
    public boolean isPossible(int nums[], int mid, int k){
        int total =1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int curr= nums[i];
            if((sum+curr)>mid){
                total++;
                sum=0;
            }
            sum+= curr;
        }
        // total++;
        return total<=k;
    }
}