public class Find_N_Unique_Integers_Sum_up_to_Zero {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int num = 1;

        for (int i = 0; i < n / 2; i++) {
            ans[i] = num;
            ans[n - 1 - i] = -num;
            num++;
        }

      
        if (n % 2 != 0) {
            ans[n / 2] = 0;
        }

        return ans;
    }
}
/*
 * 1304. Find N Unique Integers Sum up to Zero
Easy
Topics
premium lock icon
Companies
Hint
Given an integer n, return any array containing n unique integers such that they add up to 0.

 

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 

Constraints:

1 <= n <= 1000
 */

