public class Find_the_Maximum_Length_of_Valid_Subsequence_I {
    
}
/*
 * 3201. Find the Maximum Length of Valid Subsequence I
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
Return the length of the longest valid subsequence of nums.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [1,2,3,4]

Output: 4

Explanation:

The longest valid subsequence is [1, 2, 3, 4].

Example 2:

Input: nums = [1,2,1,1,2,1,2]

Output: 6

Explanation:

The longest valid subsequence is [1, 2, 1, 2, 1, 2].

Example 3:

Input: nums = [1,3]

Output: 2

Explanation:

The longest valid subsequence is [1, 3].

 

Constraints:

2 <= nums.length <= 2 * 105
1 <= nums[i] <= 107
 */

class Solution {
    public int maximumLength(int[] nums) {
        int count=0;
        int c=0;
        for(int i:nums){
            if(i%2==0){
                c++;
            }
        }
        count=Math.max(c,count);
        c=0; 
        for(int i:nums){
            if(i%2!=0){
                c++;
            }
        }
        count=Math.max(c,count);
        c=0;
        boolean odd=true;
        for(int i:nums){
            if(odd && i%2!=0){
                c++;
                odd=!odd;
            }
            if(!odd && i%2==0){
                c++;
                odd=!odd;

            }
        }
        count=Math.max(c,count);
        c=0; 
        odd=false;
        for(int i:nums){
            if(odd && i%2!=0){
                c++;
                odd=!odd;
            }
            if(!odd && i%2==0){
                c++;
                odd=!odd;
            }
        }
        return Math.max(c,count);

    }
}