import java.util.*;

public class Sum_of_Subarray_Minimums {
    
}
/*
 * 907. Sum of Subarray Minimums
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
 */


class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int nse[] = new int[n];
        int pse[] = new int[n];

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

        long ans = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            ans = (ans + (arr[i] * left % mod) * right % mod) % mod;
        }
        return (int)ans;

    }
}
