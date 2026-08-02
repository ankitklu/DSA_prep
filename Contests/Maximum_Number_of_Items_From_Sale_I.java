class Solution {
    private int helper(int[] cost, int[] gains, int idx, int target) {
        if (target == 0) {
            return 0;
        }
        
        if (target < 0) {
            return Integer.MIN_VALUE; 
        }
        
        if (idx >= cost.length) {
            return target / minPrice;
        }

        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }

        int maxReward = 0;

        if (cost[idx] <= target) {
            int take = gains[idx] + helper(cost, gains, idx + 1, target - cost[idx]);
            int skip = helper(cost, gains, idx + 1, target);
            
            maxReward = Math.max(take, skip);
        }
        else {
            maxReward = helper(cost, gains, idx + 1, target);
        }

        return dp[idx][target] = maxReward;
    }
    
    private int[][] dp;
    private int minPrice;

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        
        dp = new int[n + 1][budget + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int[] cost = new int[n];
        int[] gains = new int[n];
        minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            cost[i] = items[i][1];
            minPrice = Math.min(minPrice, cost[i]);

            int currentReward = 0;
            for (int j = 0; j < n; j++) {
                if (items[j][0] % items[i][0] == 0) {
                    currentReward++;
                }
            }
            gains[i] = currentReward;
        }

        return helper(cost, gains, 0, budget);
    }

    
}