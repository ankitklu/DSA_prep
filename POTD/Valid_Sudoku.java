public class Valid_Sudoku {
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
        int n= board.length;
        int m= board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(board[i][j]=='.'){

                    for(char c='1' ; c<='9';c++){
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
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] box = new boolean[9];

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[num]) return false;
                    row[num] = true;
                }

                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (col[num]) return false;
                    col[num] = true;
                }

                int r = 3 * (i / 3) + j / 3;
                int c = 3 * (i % 3) + j % 3;
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    if (box[num]) return false;
                    box[num] = true;
                }
            }
        }
        return true;
    }
}
