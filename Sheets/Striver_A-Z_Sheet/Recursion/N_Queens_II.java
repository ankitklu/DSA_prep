import java.util.*;

public class N_Queens_II {
    
}
/*
 * 52. N-Queens II

avatar
Discuss Approach
arrow-up
Solved
Hard
Topics
premium lock icon
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
 */

class Solution {
    public int totalNQueens(int n) {
        List<List<String>> list= new ArrayList<>();
        char board[][]= new char[n][n];
        for(char a[]:board){
            Arrays.fill(a,'.');
        }
        solveRec(list, board, 0);
        return list.size();
    }
    public void solveRec(List<List<String>> list, char board[][], int col){
        if(col==board[0].length){
            save(list, board);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isSafe(row, col,board)){
                board[row][col] = 'Q';
                solveRec(list, board, col+1);
                board[row][col] = '.';
            }
        }
    }
    public boolean isSafe(int row, int col, char board[][]){
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }

        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for(int r=row, c=col; r>=0 && c>=0; r--, c--){
            if(board[r][c]=='Q') return false;
        }

        for(int r=row, c=col; r<board.length && c>=0; r++, c--){
            if(board[r][c]=='Q') return false;
        }

        return true;
    }
    public void save(List<List<String>> res, char [][]board){
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
