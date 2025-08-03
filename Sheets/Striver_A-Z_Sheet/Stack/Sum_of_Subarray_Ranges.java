import java.util.*;

public class Sum_of_Subarray_Ranges {
    
}
/*
 * 2104. Sum of Subarray Ranges

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
 

Constraints:

1 <= nums.length <= 1000
-109 <= nums[i] <= 109
 

Follow-up: Could you find a solution with O(n) time complexity?
 */

class Solution {
    public long subArrayRanges(int[] nums) {
        long l = sumSubarrayMaxs(nums);
        long s = sumSubarrayMins(nums);
        return Math.abs(l-s);
    }
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int nse[] = new int[n]; //  1 -1 -1 -1
        int pse[] = new int[n]; // -1 -1  1  2

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && arr[dq.peek()]> arr[i]){
                dq.poll();
            }
            pse[i]= dq.isEmpty()?-1: dq.peek();
            dq.push(i);
        }
        dq.clear();

        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && arr[dq.peek()]>=arr[i]){
                dq.pop();
            }
            nse[i] = dq.isEmpty()?n: dq.peek();
            dq.push(i);
        }
        
        // int nse[] = new int[n]; //  1 -1 -1 -1
        // int pse[] = new int[n]; // -1 -1  1  2

        long ans = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i]; //1
            long right = nse[i] - i; // 1
            ans = (ans + (arr[i] * left) * right);
        }
        return ans;

    }
    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Greater or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            ans = (ans + (arr[i] * left) * right);
        }

        return ans;
    }
}


