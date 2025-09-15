public class Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int dp[][] = new int[n][m];

        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }
    public int helper(int row, int col, int n, int m, int grid[][], int dp[][]){
        if(row==n-1 && col==m-1){
            return 1;
        }
        if(row>=n || col>=m){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(grid[row][col]!=1){
            int right = helper(row, col+1, n, m, grid, dp);
            int down = helper(row+1, col, n, m, grid, dp);
            return dp[row][col] = right+down;
        }
        return dp[row][col] = 0;

    }    
}
