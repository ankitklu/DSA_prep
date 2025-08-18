/*
 * 1091. Shortest Path in Binary Matrix

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
 */
import java.util.*;
class Solution {
    static int delRow[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int delCol[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Pair{
        int row;
        int col;
        int dist;
        public Pair(int row, int col, int dist){
            this.row= row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        boolean vis[][] = new boolean[n][n];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0,0));

        int dist[][] = new int[n][n];

        for(int arr[] : dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[0][0] = 1;


        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;

            for(int i=0;i<8;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<n && grid[nRow][nCol]==0){
                    if(dist[row][col] + 1 < dist[nRow][nCol]){
                        dist[nRow][nCol] = dist[row][col]+1;
                        q.add(new Pair(nRow, nCol, dist[nRow][nCol]));
                    }
                }
            }
        }
        return dist[n-1][n-1] == Integer.MAX_VALUE? -1: dist[n-1][n-1];
    }
}