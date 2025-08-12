import java.util.*;
public class Ways_to_Express_an_Integer_as_Sum_of_Powers {
    
}
/*
 * 2787. Ways to Express an Integer as Sum of Powers

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given two positive integers n and x.

Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.

Since the result can be very large, return it modulo 109 + 7.

For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.

 

Example 1:

Input: n = 10, x = 2
Output: 1
Explanation: We can express n as the following: n = 32 + 12 = 10.
It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.
Example 2:

Input: n = 4, x = 1
Output: 2
Explanation: We can express n in the following ways:
- n = 41 = 4.
- n = 31 + 11 = 4.
 

Constraints:

1 <= n <= 300
1 <= x <= 5
 */

 
class Solution {
    static int mod= 1_000_000_007;
    public int numberOfWays(int n, int x) {
        int res[] = new int[300];
        // Set<Integer> set = new HashSet<>();
        // Set<Integer> vis = new HashSet<>();
        for(int i=1;i<=300;i++){
            int val = (int)(Math.pow(i,x));
            res[i-1] = val%mod;
        }
        int dp[][] = new int[300][n+1];
        for(int a[]: dp){
            Arrays.fill(a, -1);
        }
        return helper(0, res, n,dp)%mod;
        
    }
    public int helper(int index, int arr[], int sum, int dp[][]){
        if(index==arr.length){
            return sum==0? 1:0;
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum];
        }
        int not_take = helper(index+1, arr , sum, dp);
        int take = 0;
        if(arr[index]<= sum){
            take = helper(index+1, arr, sum-arr[index], dp);
        }
        return dp[index][sum] = (take%mod + not_take%mod)%mod;

    }
}

// 10
// 1^2 , 2^2 , 3^2 , 4^2 , 5^2 , 6^2 , 7^2
