import java.util.*;
public class Number_of_Stable_Subsequences {
    int mod = 1_000_000_007;
    int dp[][][];

    public int countStableSubsequences(int[] nums) {
        dp = new int[nums.length][3][3];
        for (int[][] mat : dp) {
            for (int[] a : mat) {
                Arrays.fill(a, -1);
            }
        }
        int ans = helper(nums, -1, -1, 0) - 1; 
        if (ans < 0) ans += mod;
        return ans;
    }

    private int helper(int[] nums, int prev, int prev2, int index) {
        if (index == nums.length) {
            return 1;
        }

        if (dp[index][prev + 1][prev2 + 1] != -1) {
            return dp[index][prev + 1][prev2 + 1];
        }

        int notTake = helper(nums, prev, prev2, index + 1);

        int curr = nums[index] % 2;
        int take = 0;
        if (!(curr == prev && curr == prev2)) {
            take = helper(nums, curr, prev, index + 1);
        }

        return dp[index][prev + 1][prev2 + 1] = (notTake + take) % mod;
    }
}
/*
 * 3686. Number of Stable Subsequences
Solved
Hard
premium lock icon
Companies
Hint
You are given an integer array nums.

A subsequence is stable if it does not contain three consecutive elements with the same parity when the subsequence is read in order (i.e., consecutive inside the subsequence).

Return the number of stable subsequences.

Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [1,3,5]

Output: 6

Explanation:

Stable subsequences are [1], [3], [5], [1, 3], [1, 5], and [3, 5].
Subsequence [1, 3, 5] is not stable because it contains three consecutive odd numbers. Thus, the answer is 6.
Example 2:

Input: nums = [2,3,4,2]

Output: 14

Explanation:

The only subsequence that is not stable is [2, 4, 2], which contains three consecutive even numbers.
All other subsequences are stable. Thus, the answer is 14.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 10​​​​​​​5
 */