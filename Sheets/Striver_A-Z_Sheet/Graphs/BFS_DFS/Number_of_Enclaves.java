/*
 * 1020. Number of Enclaves
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Hint
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
 */

public class Number_of_Enclaves {
    static int delRow[] = {-1, 0, 1, 0};
    static int delCol[] = {0, -1, 0, 1};
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(!vis[i][0] && grid[i][0]==1){
                dfs(i,0, grid, vis);
            }
            if(!vis[i][m-1] && grid[i][m-1]==1){
                dfs(i,m-1, grid, vis);
            }
        }

        for(int i=0;i<m;i++){
            if(!vis[0][i] && grid[0][i]==1){
                dfs(0,i, grid, vis);
            }
            if(!vis[n-1][i] && grid[n-1][i]==1){
                dfs(n-1,i, grid, vis);
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(int row, int col , int grid[][], boolean vis[][]){
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && !vis[nRow][nCol] && grid[nRow][nCol]==1){
                dfs(nRow, nCol, grid, vis);
            }
        }
    }
}
