/*
 * 3619. Count Islands With Total Value Divisible by K
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an m x n matrix grid and a positive integer k. An island is a group of positive integers (representing land) that are 4-directionally connected (horizontally or vertically).

The total value of an island is the sum of the values of all cells in the island.

Return the number of islands with a total value divisible by k.

 

Example 1:


Input: grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5

Output: 2

Explanation:

The grid contains four islands. The islands highlighted in blue have a total value that is divisible by 5, while the islands highlighted in red do not.

Example 2:


Input: grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3

Output: 6

Explanation:

The grid contains six islands, each with a total value that is divisible by 3.

 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
0 <= grid[i][j] <= 106
1 <= k <= 106
 */
public class Count_Islands_With_Total_Value_Divisible_by_K{
    static int delRow[] = {-1, 0, 1, 0};
    static int delCol[] = {0, -1, 0, 1};

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] != 0) {
                    int sum = dfs(grid, vis, i, j);
                    if (sum % k == 0) {
                        c++;
                    }
                }
            }
        }
        return c;
    }

    private int dfs(int[][] grid, boolean[][] vis, int row, int col) {
        vis[row][col] = true;
        int sum = grid[row][col]; 

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nCol >= 0 && nRow < vis.length && nCol < vis[0].length
                && !vis[nRow][nCol] && grid[nRow][nCol] != 0) {
                sum += dfs(grid, vis, nRow, nCol); 
            }
        }
        return sum;
    }
}