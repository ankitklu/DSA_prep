/*
 * 3197. Find the Minimum Area to Cover All Ones II
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given a 2D binary array grid. You need to find 3 non-overlapping rectangles having non-zero areas with horizontal and vertical sides such that all the 1's in grid lie inside these rectangles.

Return the minimum possible sum of the area of these rectangles.

Note that the rectangles are allowed to touch.

 

Example 1:

Input: grid = [[1,0,1],[1,1,1]]

Output: 5

Explanation:



The 1's at (0, 0) and (1, 0) are covered by a rectangle of area 2.
The 1's at (0, 2) and (1, 2) are covered by a rectangle of area 2.
The 1 at (1, 1) is covered by a rectangle of area 1.
Example 2:

Input: grid = [[1,0,1,0],[0,1,0,1]]

Output: 5

Explanation:



The 1's at (0, 0) and (0, 2) are covered by a rectangle of area 3.
The 1 at (1, 1) is covered by a rectangle of area 1.
The 1 at (1, 3) is covered by a rectangle of area 1.
 

Constraints:

1 <= grid.length, grid[i].length <= 30
grid[i][j] is either 0 or 1.
The input is generated such that there are at least three 1's in grid.
 */

class Solution {
    public int minimumSum(int[][] A) {
        int res = Integer.MAX_VALUE;

        for (int rot = 0; rot < 4; rot++) {
            int n = A.length, m = A[0].length;
            for (int i = 1; i < n; i++) {
                int a1 = minimumArea(Arrays.copyOfRange(A, 0, i));
                for (int j = 1; j < m; j++) {
                    int[][] part2 = new int[n - i][j];
                    int[][] part3 = new int[n - i][m - j];
                    for (int r = 0; r < n - i; r++) {
                        part2[r] = Arrays.copyOfRange(A[i + r], 0, j);
                        part3[r] = Arrays.copyOfRange(A[i + r], j, m);
                    }
                    int a2 = minimumArea(part2);
                    int a3 = minimumArea(part3);
                    res = Math.min(res, a1 + a2 + a3);
                }
                for (int i2 = i + 1; i2 < n; i2++) {
                    int[][] part2 = Arrays.copyOfRange(A, i, i2);
                    int[][] part3 = Arrays.copyOfRange(A, i2, n);
                    int a2 = minimumArea(part2);
                    int a3 = minimumArea(part3);
                    res = Math.min(res, a1 + a2 + a3);
                }
            }
            A = rotate(A);
        }
        return res;
    }

    private int minimumArea(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        int n = A.length, m = A[0].length;
        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
        int right = -1, bottom = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    left = Math.min(left, j);
                    top = Math.min(top, i);
                    right = Math.max(right, j);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        if (right == -1) return 0;
        return (right - left + 1) * (bottom - top + 1);
    }

    private int[][] rotate(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = A[i][j];
            }
        }
        return rotated;
    }
}