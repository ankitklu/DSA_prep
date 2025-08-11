import java.util.*;
public class Range_Product_Queries_of_Powers {
    
}
/*
 * 2438. Range Product Queries of Powers

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing order, and there is only one way to form the array.

You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.

Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] should be returned modulo 109 + 7.

 

Example 1:

Input: n = 15, queries = [[0,1],[2,2],[0,3]]
Output: [2,4,64]
Explanation:
For n = 15, powers = [1,2,4,8]. It can be shown that powers cannot be a smaller size.
Answer to 1st query: powers[0] * powers[1] = 1 * 2 = 2.
Answer to 2nd query: powers[2] = 4.
Answer to 3rd query: powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64.
Each answer modulo 109 + 7 yields the same answer, so [2,4,64] is returned.
Example 2:

Input: n = 2, queries = [[0,0]]
Output: [2]
Explanation:
For n = 2, powers = [2].
The answer to the only query is powers[0] = 2. The answer modulo 109 + 7 is the same, so [2] is returned.
 

Constraints:

1 <= n <= 109
1 <= queries.length <= 105
0 <= starti <= endi < powers.length
 */

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1_000_000_007;
        List<Integer> p = new ArrayList<>();
        for(int i = 0; i < 32; i++) {
            if((n&(1<<i)) != 0) {
                p.add((int)(Math.pow(2, i)));
            }
        }
        long[] pre = new long[p.size()];
        pre[0] = p.get(0);
        for(int i = 1; i < pre.length; i++) {
            pre[i] = ((pre[i-1]%mod)*(p.get(i)%mod))%mod;
        }
        for(int i = 0; i < pre.length; i++) {
            System.out.print(p.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < pre.length; i++) {
            System.out.print(pre[i] + " ");
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l > 0) {
                long numerator = pre[r];
                long denominatorInverse = modPow(pre[l - 1], mod - 2, mod);
                ans[i] = (int) ((numerator * denominatorInverse) % mod);
            } else {
                ans[i] = (int)pre[r];
            }
        }
        return ans;
    }

    private long modPow(long x, long n, int mod) {
        if(n == 0) return 1;
        long half = modPow(x, n/2, mod);
        long full = (half * half)%mod;
        if(n%2 == 1) full = (full * x)%mod;
        return full;
    }

}


// p = 2 4 8
// pre 2 8 64
// 2,2
// pre[2]/pre[2-1]
// 8/2 =4
