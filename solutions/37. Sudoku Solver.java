class Solution {
    public void solveSudoku(char[][] board) {
        solvedFromCell(0, 0, board);
    }
    
    private boolean solvedFromCell(int row, int col, char[][] board) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) return true;
        }
​
        if (board[row][col] != '.')
            return solvedFromCell(row, col + 1, board);
​
        for (int n = 1; n <= 9; n++) {
            char val = (char) (n + '0');
            if (valid(board, row, col, val)) {
                board[row][col] = val;
​
                if (solvedFromCell(row, col + 1, board)) {
                    return true;
                }
​
                board[row][col] = '.';
            }
        }
​
        return false;
    }
​
    private boolean valid(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++)
            if(board[i][col] == val || board[row][i] == val) return false;
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
​
​
​
​
​
}
