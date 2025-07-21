import java.util.*;

public class Count_Good_Numbers {
    
}
/*
 * 1922. Count Good Numbers
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Hint
A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303
 

Constraints:

1 <= n <= 1015
 */

class Solution {
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; 
        long oddPositions = n / 2;        

        long evenWays = power(5, evenPositions, MOD); 
        long oddWays = power(4, oddPositions, MOD);  

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long base, long exponent, int mod) {
        long result = 1;
        base %= mod;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }

        return result;
    }
}

// n=1
// 0 2 4 6 8 

//n=2
// 02 //02 // 0

// 0 2 4 6 8
// 0 -> 01 03 05 07 
// 2 -> 21 23 25 27
// 4 -> 41 43 45 47
// 6 -> 61 63 65 67
// 8 -> 81 83 85 87

// 01 -> 010 012 014 016 018
