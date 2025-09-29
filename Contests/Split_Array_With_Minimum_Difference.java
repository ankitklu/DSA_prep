public class Split_Array_With_Minimum_Difference{
    public long splitArray(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;    
        long sumL = nums[i], sumR = nums[j]; 

        while (i < n - 1 && nums[i] < nums[i + 1]) 
            sumL += nums[++i];

        while (j > 0 && nums[j - 1] > nums[j]) 
            sumR += nums[--j];

        if (i == j) 
            return Math.abs(Math.max(sumL, sumR) - nums[i] - Math.min(sumL, sumR));

        if (j == i + 1) 
            return Math.abs(sumR - sumL);

        return -1;
    }

}
/*
 * 3698. Split Array With Minimum Difference
Solved
Medium
premium lock icon
Companies
Hint
You are given an integer array nums.

Split the array into exactly two subarrays, left and right, such that left is strictly increasing and right is strictly decreasing.

Return the minimum possible absolute difference between the sums of left and right. If no valid split exists, return -1.

 

Example 1:

Input: nums = [1,3,2]

Output: 2

Explanation:

i	left	right	Validity	left sum	right sum	Absolute difference
0	[1]	[3, 2]	Yes	1	5	|1 - 5| = 4
1	[1, 3]	[2]	Yes	4	2	|4 - 2| = 2
Thus, the minimum absolute difference is 2.

Example 2:

Input: nums = [1,2,4,3]

Output: 4

Explanation:

i	left	right	Validity	left sum	right sum	Absolute difference
0	[1]	[2, 4, 3]	No	1	9	-
1	[1, 2]	[4, 3]	Yes	3	7	|3 - 7| = 4
2	[1, 2, 4]	[3]	Yes	7	3	|7 - 3| = 4
Thus, the minimum absolute difference is 4.

Example 3:

Input: nums = [3,1,2]

Output: -1

Explanation:

No valid split exists, so the answer is -1.

 

Constraints:

2 <= nums.length <= 105
1 <= nums[i] <= 105
 


 */