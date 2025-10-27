import java.util.HashMap;
import java.util.Map;

public class Stable_Subarrays_With_Equal_Boundary_and_Interior_Sum {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long[] pre = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + capacity[i];
        }

        Map<Integer, Map<Long, Long>> groupMap = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        //     map.computeIfAbsent(capacity[i], k -> new ArrayList<>()).add(i);
        // }

        // long count = 0;

        // for (List<Integer> indices : map.values()) {
        //     int m = indices.size();
        //     if (m < 2) continue;

        //     for (int i = 0; i < m; i++) {
        //         for (int j = i + 1; j < m; j++) {
        //             int left = indices.get(i);
        //             int right = indices.get(j);

        //             if (right - left < 2) continue;

        //             long sumBetween = pre[right - 1] - pre[left];
        //             if (sumBetween == capacity[left]) {
        //                 count++;
        //             }
        //         }
        //     }
        // }

        // return count;

        

        
        long ans = 0;
        long prefix =0;

        for (int i = 0; i < n; i++) {
            int val = capacity[i];
            Map<Long, Long> freqMap = groupMap.computeIfAbsent(val, k -> new HashMap<>());

            ans += freqMap.getOrDefault(prefix - val, 0L);

            prefix += val;

            freqMap.put(prefix, freqMap.getOrDefault(prefix, 0L) + 1L);

            if (val == 0 && i > 0 && capacity[i - 1] == 0)
                ans--;
        }
        return ans;

    }
}

/*
 * 3728. Stable Subarrays With Equal Boundary and Interior Sum
Solved
Medium
premium lock icon
Companies
Hint
You are given an integer array capacity.

A subarray capacity[l..r] is considered stable if:

Its length is at least 3.
The first and last elements are each equal to the sum of all elements strictly between them (i.e., capacity[l] = capacity[r] = capacity[l + 1] + capacity[l + 2] + ... + capacity[r - 1]).
Return an integer denoting the number of stable subarrays.

 

Example 1:

Input: capacity = [9,3,3,3,9]

Output: 2

Explanation:

[9,3,3,3,9] is stable because the first and last elements are both 9, and the sum of the elements strictly between them is 3 + 3 + 3 = 9.
[3,3,3] is stable because the first and last elements are both 3, and the sum of the elements strictly between them is 3.
Example 2:

Input: capacity = [1,2,3,4,5]

Output: 0

Explanation:

No subarray of length at least 3 has equal first and last elements, so the answer is 0.

Example 3:

Input: capacity = [-4,4,0,0,-8,-4]

Output: 1

Explanation:

[-4,4,0,0,-8,-4] is stable because the first and last elements are both -4, and the sum of the elements strictly between them is 4 + 0 + 0 + (-8) = -4

 

Constraints:

3 <= capacity.length <= 105
-109 <= capacity[i] <= 109
 */
