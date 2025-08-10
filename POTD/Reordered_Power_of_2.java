/*
 * 869. Reordered Power of 2

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

 

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
 

Constraints:

1 <= n <= 109
 */

class Solution {
    int[] toFreqArray(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        return freq;
    }

    boolean isEqualFrequency(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    boolean reorderedPowerOf2(int n) {
        int[] target = toFreqArray(n);

        for (int i = 0; i < 31; i++) {
            int powerOf2 = 1 << i;
            if (isEqualFrequency(target, toFreqArray(powerOf2))) {
                return true;
            }
        }
        return false;
    }

}
// 2  32   512
// 4  64
// 8  128
// 16 256