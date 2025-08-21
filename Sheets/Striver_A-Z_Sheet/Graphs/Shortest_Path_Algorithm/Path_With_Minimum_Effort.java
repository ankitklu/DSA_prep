import java.util.*;
public class Path_With_Minimum_Effort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];
        for(int arr[] : dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};

        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        // int minEffort = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int effort = top[0];
            int row= top[1];
            int col = top[2];

            if(row==n-1 && col==m-1){
                return effort;
            }
            
            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m ){
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[nRow][nCol]));
                    if (newEffort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = newEffort;
                        pq.add(new int[]{newEffort, nRow, nCol});
                    }
                }

            }
        }
        // return dist[n-1][m-1] == -1 ? -1 :dist[n-1][m-1];
        return 0;


    }
}
/*
 * 1631. Path With Minimum Effort
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Hint
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
 */
