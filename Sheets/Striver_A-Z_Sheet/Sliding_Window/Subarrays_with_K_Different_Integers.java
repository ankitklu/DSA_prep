import java.util.*;
public class Subarrays_with_K_Different_Integers {
    
}
/*
 * 992. Subarrays with K Different Integers
Solved

avatar
Discuss Approach
arrow-up
Hard
Topics
premium lock icon
Companies
Hint
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
 */

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atleastK= submaxK(nums, k);
        int atleastKdec= submaxK(nums, k-1);
        return atleastK-atleastKdec;
    }
    public int submaxK(int nums[], int k){
        HashMap<Integer, Integer> map= new HashMap<>();
        int left=0;
        int right=0;
        int n=nums.length;

        int maxLen=0;
        while(right<n){
            int curr= nums[right];
            map.put(curr, map.getOrDefault(curr,0)+1);

            while(map.size()>k){
                int ele= nums[left];
                map.put(ele, map.get(ele)-1);
                if(map.get(ele)==0){
                    map.remove(ele);
                }
                left++;
            }
            maxLen+= right-left+1;
            right++;
        }
        return maxLen;
    }
}
