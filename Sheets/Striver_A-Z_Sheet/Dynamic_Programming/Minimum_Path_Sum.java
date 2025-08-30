public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[n-1][m-1];
    }
    public int helper(int row, int col, int n, int m, int[][] grid, int dp[][]) {
        if (row == n - 1 && col == m - 1) {
            return grid[row][col];
        }
        if (row >= n || col >= m) {
            return Integer.MAX_VALUE;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int right = helper(row, col + 1, n, m, grid, dp);
        int down = helper(row + 1, col, n, m, grid, dp);
        return dp[row][col] = Math.min(right, down) + grid[row][col];
    }
}
