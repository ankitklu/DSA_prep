import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Escape_the_Spreading_Fire {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] fire = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int[] row : fire) Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fire[i][j] = 0;
                    q.offer(new int[]{i, j, 0});
                } else if (grid[i][j] == 2) {
                    fire[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.peek()[1];
            int t = q.peek()[2];
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (grid[nr][nc] == 2) continue;
                if (fire[nr][nc] <= t + 1) continue;

                fire[nr][nc] = t + 1;
                q.offer(new int[]{nr, nc, t + 1});
            }
        }

        int l = 0, u = 1000000000, ans = -1;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (canReach(fire, mid, grid)) {
                ans = mid;
                l = mid + 1;
            } else {
                u = mid - 1;
            }
        }

        return ans;
    }
    public boolean canReach(int[][] fire, int wait, int[][] grid) {
        int m = fire.length, n = fire[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, wait});
        vis[0][0] = true;

        if (fire[0][0] <= wait) return false;

        while (!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.peek()[1];
            int time = q.peek()[2];
            q.remove();

            if (r == m - 1 && c == n - 1) return true; 

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                int arriveTime = time + 1;

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (vis[nr][nc] || grid[nr][nc] == 2) continue;

                if (nr == m - 1 && nc == n - 1) {
                    if (fire[nr][nc] >= arriveTime) return true;
                }

                if (fire[nr][nc] > arriveTime) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc, arriveTime});
                }
            }
        }
        return false;
    }
}

/*
 * 2258. Escape the Spreading Fire
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given a 0-indexed 2D integer array grid of size m x n which represents a field. Each cell has one of three values:

0 represents grass,
1 represents fire,
2 represents a wall that you and fire cannot pass through.
You are situated in the top-left cell, (0, 0), and you want to travel to the safehouse at the bottom-right cell, (m - 1, n - 1). Every minute, you may move to an adjacent grass cell. After your move, every fire cell will spread to all adjacent cells that are not walls.

Return the maximum number of minutes that you can stay in your initial position before moving while still safely reaching the safehouse. If this is impossible, return -1. If you can always reach the safehouse regardless of the minutes stayed, return 109.

Note that even if the fire spreads to the safehouse immediately after you have reached it, it will be counted as safely reaching the safehouse.

A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).

 

Example 1:


Input: grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
Output: 3
Explanation: The figure above shows the scenario where you stay in the initial position for 3 minutes.
You will still be able to safely reach the safehouse.
Staying for more than 3 minutes will not allow you to safely reach the safehouse.
Example 2:


Input: grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
Output: -1
Explanation: The figure above shows the scenario where you immediately move towards the safehouse.
Fire will spread to any cell you move towards and it is impossible to safely reach the safehouse.
Thus, -1 is returned.
Example 3:


Input: grid = [[0,0,0],[2,2,0],[1,2,0]]
Output: 1000000000
Explanation: The figure above shows the initial grid.
Notice that the fire is contained by walls and you will always be able to safely reach the safehouse.
Thus, 109 is returned.
 

Constraints:

m == grid.length
n == grid[i].length
2 <= m, n <= 300
4 <= m * n <= 2 * 104
grid[i][j] is either 0, 1, or 2.
grid[0][0] == grid[m - 1][n - 1] == 0
 */
