public class Sudoku_Solver {
    public boolean possible(char board[][], int row, int col, char ch){
        for(int i=0;i<board.length;i++){
            if(board[row][i]==ch){
                return false;
            }

            else if(board[i][col]==ch){
                return false;
            }

            else if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch){
                return false;
            }

        }
        return true;
    }
    public boolean solve(char board[][]){
        int n=board.length;
        int m=board.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.'){

                    for(char c='1';c<='9';c++){
                        if(possible(board, i, j, c)){
                            board[i][j]=c;

                            if(solve(board)==true){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
