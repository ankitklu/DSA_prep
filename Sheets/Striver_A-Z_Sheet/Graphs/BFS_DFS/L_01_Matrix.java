import java.util.*;
/*
 * 542. 01 Matrix

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 

Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/
 */


public class L_01_Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};

        int n= mat.length;
        int m= mat[0].length;

        boolean vis[][] = new boolean[n][m];

        int dist[][]= new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            int top[] = q.poll();
            int row = top[0];
            int col = top[1];

            for(int i=0;i<4;i++){
                int nRow = row+ delRow[i];
                int  nCol = col + delCol[i];
                
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && !vis[nRow][nCol] && dist[nRow][nCol] > dist[row][col]+1){
                    q.add(new int[]{nRow, nCol});
                    dist[nRow][nCol] = dist[row][col] + 1;
                    vis[nRow][nCol] = true;
                }
            }
        }
        return dist;

    }
}
