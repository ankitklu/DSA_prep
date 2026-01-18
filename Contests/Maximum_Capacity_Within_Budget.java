/*
3814. Maximum Capacity Within Budget
Solved
Medium
premium lock icon
Companies
Hint
You are given two integer arrays costs and capacity, both of length n, where costs[i] represents the purchase cost of the ith machine and capacity[i] represents its performance capacity.

You are also given an integer budget.

You may select at most two distinct machines such that the total cost of the selected machines is strictly less than budget.

Return the maximum achievable total capacity of the selected machines.

 

Example 1:

Input: costs = [4,8,5,3], capacity = [1,5,2,7], budget = 8

Output: 8

Explanation:

Choose two machines with costs[0] = 4 and costs[3] = 3.
The total cost is 4 + 3 = 7, which is strictly less than budget = 8.
The maximum total capacity is capacity[0] + capacity[3] = 1 + 7 = 8.
Example 2:

Input: costs = [3,5,7,4], capacity = [2,4,3,6], budget = 7

Output: 6

Explanation:

Choose one machine with costs[3] = 4.
The total cost is 4, which is strictly less than budget = 7.
The maximum total capacity is capacity[3] = 6.
Example 3:

Input: costs = [2,2,2], capacity = [3,5,4], budget = 5

Output: 9

Explanation:

Choose two machines with costs[1] = 2 and costs[2] = 2.
The total cost is 2 + 2 = 4, which is strictly less than budget = 5.
The maximum total capacity is capacity[1] + capacity[2] = 5 + 4 = 9.
 

Constraints:

1 <= n == costs.length == capacity.length <= 105
1 <= costs[i], capacity[i] <= 105
1 <= budget <= 2 * 105
*/

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] machines = new int[n][2];

        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }

        Arrays.sort(machines, Comparator.comparingInt(a -> a[0]));

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (machines[i][0] < budget) {
                ans = Math.max(ans, machines[i][1]);
            }
        }

        int[] prefixmax = new int[n];
        prefixmax[0] = machines[0][1];
        for (int i = 1; i < n; i++) {
            prefixmax[i] = Math.max(prefixmax[i - 1], machines[i][1]);
        }

        for (int r = 1; r < n; r++) {
            int remaining = budget - machines[r][0];
            if (remaining <= 0) continue;

            int l = 0, h = r - 1, idx = -1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (machines[mid][0] < remaining) {
                    idx = mid;
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }

            if (idx != -1) {
                ans = Math.max(ans, prefixmax[idx] + machines[r][1]);
            }
        }

        return ans;
    }
}


// 4->1
// 8->5
// 5->2
// 3->7

// 4->1
// 5->2
// 8->5
// 3->7

// 3->7
// 4->1
// 5->2
// 8->5
