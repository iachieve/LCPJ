class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char curr = board[r][c];
                if(curr != '.'){
                    if(
                    !seen.add(curr + " in row " + r) ||
                    !seen.add(curr + " in col " + c) ||
                    !seen.add(curr + " in box " + r/3 + "-" + c/3)
                ){
                    return false;
                }
                }
            }   
        }
        return true;
    }
}
