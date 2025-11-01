// https://read.learnyard.com/online-assessment-dsa-questions/flipkart/shortest-distance-between-two-cities/

public class Flipkart_OA3 {
    public static void main(String[] args) {
        int numRows = 3;
        int numCols = 4;
        int[][] grid = {
            {3, 2, 2, 1},
            {6, 2, 3, 4},
            {4, 7, 6, 8}
        };

        System.out.println(maxGoodsCollected(grid, numRows, numCols));
    }

    public static int maxGoodsCollected(int[][] grid, int n, int m) {
        int[][][] dp = new int[n][m][m];

        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = 0; c2 < m; c2++) {
                if (c1 == c2)
                    dp[n - 1][c1][c2] = grid[n - 1][c1];
                else
                    dp[n - 1][c1][c2] = grid[n - 1][c1] + grid[n - 1][c2];
            }
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    int maxVal = 0;
                    for (int move1 = -1; move1 <= 1; move1++) {
                        for (int move2 = -1; move2 <= 1; move2++) {
                            int newC1 = c1 + move1;
                            int newC2 = c2 + move2;
                            if (newC1 >= 0 && newC1 < m && newC2 >= 0 && newC2 < m) {
                                maxVal = Math.max(maxVal, dp[row + 1][newC1][newC2]);
                            }
                        }
                    }

                    if (c1 == c2)
                        dp[row][c1][c2] = grid[row][c1] + maxVal;
                    else
                        dp[row][c1][c2] = grid[row][c1] + grid[row][c2] + maxVal;
                }
            }
        }

        return dp[0][0][m - 1];
    }

}

/*
 * Problem Description
An e-commerce company’s warehouse is represented as an N x M grid in their system. Each cell in the grid represents a storage unit where goods are stored, and the value of each cell indicates the total count of goods in that unit.

Robot 1 starts at the top-left corner of the grid, positioned at (0, 0).
Robot 2 starts at the top-right corner of the grid, positioned at (0, M-1).
From any cell (a, b) in the grid, both robots can move to the next row in one of three ways:

(a+1, b): Move directly down.
(a+1, b-1): Move down-left.
(a+1, b+1): Move down-right.
If both robots land on the same cell, only one of them can pick up the goods in that cell. Once goods from a cell are collected, the cell’s value is set to zero in the system.

 Design an algorithm to calculate the maximum number of goods that both robots can collect.

Input Format:
The first line contains two space-separated integers:
numRows: Total number of rows (N).
numCols: Total number of columns (M).
The next N lines each contain M space-separated integers representing the count of goods in each cell of the warehouse.
Output Format:
Print a single integer representing the maximum number of goods that can be picked by both robots.
Constraints:
2 <= numRows, numCols <= 50

Example:
Input:

3 4
3 2 2 1
6 2 3 4
4 7 6 8
Output:

29
Explanation:

Robot 1 starts at position (0,0) and Robot 2 starts at position (0,3).
Robot 1's Path: (0,0) → (1,0) → (2,1)
Total goods collected by Robot 1: 3 + 6 + 7 = 16
Robot 2's Path: (0,3) → (1,3) → (2,3)
Total goods collected by Robot 2: 1 + 4 + 8 = 13
Total goods collected = 16 + 13 = 29

 */