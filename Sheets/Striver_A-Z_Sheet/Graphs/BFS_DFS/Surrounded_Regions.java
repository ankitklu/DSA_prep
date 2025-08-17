public class Surrounded_Regions {
    static int delRow[] = {-1, 0, 1, 0};
    static int delCol[] = {0, -1, 0, 1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean vis[][] = new boolean[n][m];

        for(int i=0;i<m;i++){
            if(!vis[0][i] && board[0][i]=='O'){
                dfs(0,i,board, vis);
            }
            if(!vis[n-1][i] && board[n-1][i]=='O'){
                dfs(n-1,i, board, vis);
            }
        }

        for(int i=0;i<n;i++){
            if(!vis[i][0] && board[i][0]=='O'){
                dfs(i,0,board,vis);
            }
            if(!vis[i][m-1] && board[i][m-1]=='O'){
                dfs(i,m-1,board,vis);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }
    public void dfs(int row, int col, char board[][], boolean vis[][]){
        vis[row][col] = true;

        for(int i=0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow>=0 && nRow<board.length && nCol>=0 && nCol<board[0].length && !vis[nRow][nCol] && board[nRow][nCol]=='O'){
                dfs(nRow, nCol, board, vis);
            }
        }
        
    }
}

/*
 * 130. Surrounded Regions
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */
