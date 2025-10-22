import java.util.*;

public class Zomato_OA_2 {
    static long sum = 0;
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        int A = 1, B = 1, C = 1;
        backtrack("", A, B, C);
        System.out.println(sum % MOD);
    }

    static void backtrack(String curr, int a, int b, int c) {
        if (!curr.isEmpty()) {
            sum = (sum + Long.parseLong(curr)) % MOD;
        }

        if (a > 0) backtrack(curr + "4", a - 1, b, c);
        if (b > 0) backtrack(curr + "5", a, b - 1, c);
        if (c > 0) backtrack(curr + "6", a, b, c - 1);
    }
}
/*
 * Problem Description
Given three integers A, B, and C, the goal is to compute the sum of all possible numbers that can be formed using the digit 4 up to A times, the digit 5 up to B times, and the digit 6 up to C times.

Note: Output the sum modulo (10^9 + 7).

Input Format:
Three integers A, B, and C.
Output Format:
A single integer representing the sum of all the numbers formed.
Constraints:
(0 <= A, B, C <= 60)
Example 1:
Input:

A = 1, B = 1, C = 1
Output:

3675
Explanation:

The possible numbers are: 4, 5, 6, 45, 54, 56, 65, 46, 64, 456, 465, 546, 564, 645, 654. The sum of these numbers is 3675.

Example 2:
Input:

A = 0, B = 0, C = 0
Output:

0
Explanation:

No valid number can be generated, so the sum is 0.
 */
