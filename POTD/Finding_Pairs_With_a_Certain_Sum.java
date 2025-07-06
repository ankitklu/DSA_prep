import java.util.*;
public class Finding_Pairs_With_a_Certain_Sum {
    
}

// 1865. Finding Pairs With a Certain Sum

// avatar
// Discuss Approach
// arrow-up
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:

// Add a positive integer to an element of a given index in the array nums2.
// Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
// Implement the FindSumPairs class:

// FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
// void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
// int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
 

// Example 1:

// Input
// ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
// [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
// Output
// [null, 8, null, 2, 1, null, null, 11]

// Explanation
// FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]);
// findSumPairs.count(7);  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
// findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
// findSumPairs.count(8);  // return 2; pairs (5,2), (5,4) make 3 + 5
// findSumPairs.count(4);  // return 1; pair (5,0) makes 3 + 1
// findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
// findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
// findSumPairs.count(7);  // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
 

// Constraints:

// 1 <= nums1.length <= 1000
// 1 <= nums2.length <= 105
// 1 <= nums1[i] <= 109
// 1 <= nums2[i] <= 105
// 0 <= index < nums2.length
// 1 <= val <= 105
// 1 <= tot <= 109
// At most 1000 calls are made to add and count each.

class FindSumPairs {
    Map<Integer, Integer> map1;
    Map<Integer, Integer> map2;
    int[] nums1, nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        for (int x : nums1) map1.put(x, map1.getOrDefault(x, 0) + 1);
        for (int x : nums2) map2.put(x, map2.getOrDefault(x, 0) + 1);
    }

    public void add(int index, int val) {
        int old = nums2[index];
        int updated = old + val;
        nums2[index] = updated;

        map2.put(old, map2.get(old) - 1);
        if (map2.get(old) == 0) map2.remove(old);
        map2.put(updated, map2.getOrDefault(updated, 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int x : map1.keySet()) {
            int y = tot - x;
            if (map2.containsKey(y)) {
                ans += map1.get(x) * map2.get(y);
            }
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
