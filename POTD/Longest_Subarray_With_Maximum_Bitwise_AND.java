public class Longest_Subarray_With_Maximum_Bitwise_AND {
    
}
/*
 * This class is a placeholder for the implementation of the problem
 *
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0, length = 0, max = 0;
        for (int ele : nums) {
            max = Math.max(max, ele);
        }

        for (int ele : nums) {
            if (ele == max) {
                result = Math.max(result, ++length);
            } else length = 0;
        }
        return result;
    }
}
