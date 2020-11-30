class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int r = 0; r < 9; r++){
            for(int c =0; c < 9; c++){
                if(board[r][c] != '.') continue;
                for(char pos = '1'; pos <= '9'; pos++){
                    if(valid(board, r, c, pos)){
                        board[r][c] = pos;
                        if(solve(board)) return true;
                        else board[r][c] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean valid(char[][] board, int r, int c, char pos) {
        for (int i = 0; i < 9; i++)
            if (board[i][c] == pos || board[r][i] == pos) return false;
​
        int topLeftRow = r - r % 3, topLeftCol = c - c % 3;
​
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (pos == board[topLeftRow + i][topLeftCol + j])
                    return false;
​
        return true;
    }
}
