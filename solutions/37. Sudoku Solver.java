class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') continue;
                for (char number = '1'; number <= '9'; number++) {
                    if (isValid(board, r, c, number)) {
                        board[r][c] = number;
                        if (solve(board)) return true;
                        else board[r][c] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
​
    private boolean isValid(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++)
            if (board[i][col] == val || board[row][i] == val) return false;
​
        int topLeftRow = row - row % 3;
        int topLeftCol = col - col % 3;
​
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (val == board[topLeftRow + i][topLeftCol + j])
                    return false;
​
        return true;
    }
}
