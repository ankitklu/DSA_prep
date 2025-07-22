import java.util.*;
public class N_Queens {
    
}
/*
 * 51. N-Queens
Solved

avatar
Discuss Approach
arrow-up
Hard
Topics
premium lock icon
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list= new ArrayList<>();
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');  
        }
        solveRec(list, board, 0);
        return list;
    }

    public void solveRec(List<List<String>> list, char board[][], int col){
        if(col==board[0].length){
            save(list, board);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col] ='Q';
                solveRec(list, board,col+1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, char board[][]){
        for(int j=0; j<board[0].length; j++){
            if(board[row][j]=='Q') return false;
        }

        for(int i=0; i<board.length; i++){
            if(board[i][col]=='Q') return false;
        }

        for(int r=row, c=col; r>=0 && c>=0; r--, c--){
            if(board[r][c]=='Q') return false;
        }

        for(int r=row, c=col; r<board.length && c>=0; r++, c--){
            if(board[r][c]=='Q') return false;
        }

        return true;
    }

    private void save(List<List<String>> res, char [][]board){
        List<String> l = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            StringBuilder str = new StringBuilder(); 
            for(int j=0; j<board[0].length; j++){
                str.append(board[i][j]);
            }
            l.add(str.toString());
        }
        res.add(l);
    }
}

