import java.util.Arrays;

public class Longest_Non_Decreasing_Subarray_After_Replacing_at_Most_One_Element {
    public int longestSubarray(int[] A) {
            int n = A.length;
            int[] left = new int[n];
            int right[] = new int[n];
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);

            for (int i = 1; i < n; i++){
                if (A[i - 1] <= A[i]){
                    left[i] = left[i - 1] + 1;
                }
            }

            for (int i = n - 2; i >= 0; i--){

                if (A[i] <= A[i + 1]){
                    right[i] = right[i + 1] + 1;
                }
            }
            int res = Math.min(n, Arrays.stream(left).max().getAsInt() + 1);

            for (int i = 1; i < n - 1; i++){
                if (A[i - 1] <= A[i + 1]){
                    res = Math.max(res, left[i - 1] + 1 + right[i + 1]);
                }
            }
            return res;
    }
}

/*
 * 3738. Longest Non-Decreasing Subarray After Replacing at Most One Element
Solved
Medium
premium lock icon
Companies
Hint
You are given an integer array nums.

You are allowed to replace at most one element in the array with any other integer value of your choice.

Return the length of the longest non-decreasing subarray that can be obtained after performing at most one replacement.

An array is said to be non-decreasing if each element is greater than or equal to its previous one (if it exists).

 

Example 1:

Input: nums = [1,2,3,1,2]

Output: 4

Explanation:

Replacing nums[3] = 1 with 3 gives the array [1, 2, 3, 3, 2].

The longest non-decreasing subarray is [1, 2, 3, 3], which has a length of 4.

Example 2:

Input: nums = [2,2,2,2,2]

Output: 5

Explanation:

All elements in nums are equal, so it is already non-decreasing and the entire nums forms a subarray of length 5.

 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109​​​​​​​
 */
