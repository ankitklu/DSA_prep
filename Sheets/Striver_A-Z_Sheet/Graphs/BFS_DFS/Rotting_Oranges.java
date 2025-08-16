import java.util.*;
/*
 * 994. Rotting Oranges
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */

public class Rotting_Oranges {
    static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    // static int delRow[] = {};
    // static int delCol[] = {};
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;

        boolean vis[][]= new boolean[n][m];
        int c=0;

        Queue<Pair> q = new LinkedList<>();
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    vis[i][j] = true;
                    q.add(new Pair(i,j,0)); 
                }
                else{
                    vis[i][j] = false;
                }
                if(grid[i][j]==1){
                    c++;
                }
            }
        }

        int max = 0;
        int count =0;

        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            int time = top.time;

            max = Math.max(max, time);
            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !vis[nRow][nCol] && grid[nRow][nCol]==1){
                    vis[nRow][nCol] = true;
                    count++;
                    q.add(new Pair(nRow, nCol, time+1));
                }
            }
            
        }
        return count==c? max:-1;
        
    }    
}
