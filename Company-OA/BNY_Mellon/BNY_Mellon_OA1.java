import java.util.HashMap;
import java.util.Map;

public class BNY_Mellon_OA1 {
    public static long maxBalancedScore(int[] stockPrices) {
        Map<Long, Long> map = new HashMap<>();
        long maxScore = 0;

        for (int i = 0; i < stockPrices.length; i++) {
            long key = (long) stockPrices[i] - i;
            long sum = map.getOrDefault(key, 0L) + stockPrices[i];
            map.put(key, sum);
            maxScore = Math.max(maxScore, sum);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] stockPrices = {1, 5, 3, 7, 8};
        System.out.println(maxBalancedScore(stockPrices));  // Output: 20
    }
}
/*
 * Problem Description
A data analyst is given an array stockPrices[], representing the prices of a stock over the past n days. The task is to select a subsequence of stock prices, referred to as selectedDays. This subsequence is considered balanced if the following condition holds:

For any i > 0, the difference between consecutive prices in the subsequence (stockPrices[selectedDays[i]] - stockPrices[selectedDays[i - 1]]) must be equal to the difference in their respective day indices (selectedDays[i] - selectedDays[i - 1]).

The score of a subsequence is the sum of the stock prices on the selected days. Your goal is to find the maximum possible score that can be achieved by selecting an optimally balanced subsequence.

Note:

A subsequence is a sequence of elements from the array that appears in the same order as the original.
A subsequence consisting of only one element is always considered balanced.
Constraints
(1 <= n <= 10^5)
(1 <= stockPrice[i] <= 10^9)
Example
Input

n = 5, stockPrice = [1, 5, 3, 7, 8].

Output

20

Explanation

Then, the subsequence ([5, 7, 8]) can be chosen. Corresponding chosen days are ([1, 3, 4]) (considering 0-based indexing). Now:

stockPrice[3] - stockPrice[1] = 7 - 5 = 2 = 3 - 1
stockPrice[4] - stockPrice[3] = 8 - 7 = 1 = 4 - 3
Thus, the subsequence is balanced.

Score = (5 + 7 + 8 = 20), which is the maximum possible. So, the answer is (20).
 */
