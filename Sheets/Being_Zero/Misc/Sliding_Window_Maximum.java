package Sheets.Being_Zero.Misc;
import java.util.*;

public class Sliding_Window_Maximum {
    
}
/*
 * 239. Sliding Window Maximum

avatar
Discuss Approach
arrow-up
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int ans[] = new int[n-k+1];
        Deque<Integer> dq= new ArrayDeque<>();
        int idx=0;

        int left=0;
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<left){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i-left+1==k){
                ans[idx++] = nums[dq.peekFirst()];
                left++;
            }
        }
        return ans;
    }
}
