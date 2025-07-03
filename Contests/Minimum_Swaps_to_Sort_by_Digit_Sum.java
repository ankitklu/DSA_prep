package Contests;
import java.util.*;
class Solution {
    public int minSwaps(int[] nums) {
        int[][] pairs = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = sumDigits(nums[i]);
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            else {
                return Integer.compare(a[0], b[0]);
            }
        });

        Map<Integer, Integer> original = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            original.put(nums[i], i);
        }
        
        boolean[] visited = new boolean[nums.length];
        int numSwaps = 0;

        for (int i = 0; i < nums.length; i++) {
            int correctValue = pairs[i][0];
            int correctIndex = original.get(correctValue);

            if (visited[i] || correctIndex == i) continue;

            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {  
                visited[j] = true;
                int nextValue = pairs[j][0]; 
                j = original.get(nextValue); 
                cycleSize++; 
            }

            if (cycleSize > 1) numSwaps += (cycleSize-1);
        }

        return numSwaps;
    }

    public int sumDigits(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}

// 3551. Minimum Swaps to Sort by Digit Sum

// avatar
// Discuss Approach
// arrow-up
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array nums of distinct positive integers. You need to sort the array in increasing order based on the sum of the digits of each number. If two numbers have the same digit sum, the smaller number appears first in the sorted order.

// Return the minimum number of swaps required to rearrange nums into this sorted order.

// A swap is defined as exchanging the values at two distinct positions in the array.

 

// Example 1:

// Input: nums = [37,100]

// Output: 1

// Explanation:

// Compute the digit sum for each integer: [3 + 7 = 10, 1 + 0 + 0 = 1] → [10, 1]
// Sort the integers based on digit sum: [100, 37]. Swap 37 with 100 to obtain the sorted order.
// Thus, the minimum number of swaps required to rearrange nums is 1.
// Example 2:

// Input: nums = [22,14,33,7]

// Output: 0

// Explanation:

// Compute the digit sum for each integer: [2 + 2 = 4, 1 + 4 = 5, 3 + 3 = 6, 7 = 7] → [4, 5, 6, 7]
// Sort the integers based on digit sum: [22, 14, 33, 7]. The array is already sorted.
// Thus, the minimum number of swaps required to rearrange nums is 0.
// Example 3:

// Input: nums = [18,43,34,16]

// Output: 2

// Explanation:

// Compute the digit sum for each integer: [1 + 8 = 9, 4 + 3 = 7, 3 + 4 = 7, 1 + 6 = 7] → [9, 7, 7, 7]
// Sort the integers based on digit sum: [16, 34, 43, 18]. Swap 18 with 16, and swap 43 with 34 to obtain the sorted order.
// Thus, the minimum number of swaps required to rearrange nums is 2.
 

// Constraints:

// 1 <= nums.length <= 105
// 1 <= nums[i] <= 109
// nums consists of distinct positive integers.
