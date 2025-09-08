import java.util.Arrays;
import java.util.Stack;

public class Count_Bowl_Subarrays {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        Arrays.fill(prevGreater, -1);
        Arrays.fill(nextGreater, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                prevGreater[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nextGreater[i] = st.peek();
            }
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (prevGreater[i] != -1 && nextGreater[i] != -1) {
                ans++;
            }
        }

        return (int) ans;
    }
}
/*
 * 3676. Count Bowl Subarrays
Solved
Medium
premium lock icon
Companies
Hint
You are given an integer array nums with distinct elements.

A subarray nums[l...r] of nums is called a bowl if:

The subarray has length at least 3. That is, r - l + 1 >= 3.
The minimum of its two ends is strictly greater than the maximum of all elements in between. That is, min(nums[l], nums[r]) > max(nums[l + 1], ..., nums[r - 1]).
Return the number of bowl subarrays in nums.

 

Example 1:

Input: nums = [2,5,3,1,4]

Output: 2

Explanation:

The bowl subarrays are [3, 1, 4] and [5, 3, 1, 4].

[3, 1, 4] is a bowl because min(3, 4) = 3 > max(1) = 1.
[5, 3, 1, 4] is a bowl because min(5, 4) = 4 > max(3, 1) = 3.
Example 2:

Input: nums = [5,1,2,3,4]

Output: 3

Explanation:

The bowl subarrays are [5, 1, 2], [5, 1, 2, 3] and [5, 1, 2, 3, 4].

Example 3:

Input: nums = [1000000000,999999999,999999998]

Output: 0

Explanation:

No subarray is a bowl.

 

Constraints:

3 <= nums.length <= 105
1 <= nums[i] <= 109
nums consists of distinct elements.
 */
