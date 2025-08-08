import java.util.*;

public class Divide_Array_in_Sets_of_K_Consecutive_Numbers {
    
}
/*
 * 1296. Divide Array in Sets of K Consecutive Numbers

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.

Return true if it is possible. Otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.
 

Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 109
 */
class Solution {
    static class Pair {
        int val;
        int freq;

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {
            int first = map.firstKey(); 
            for (int i = 0; i < k; i++) {
                int current = first + i;
                if (!map.containsKey(current)) {
                    return false;
                }
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) {
                    map.remove(current);
                }
            }
        }

        return true;
    }
}

