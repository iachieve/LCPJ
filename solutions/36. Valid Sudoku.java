class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j <9; j++){
                char curr = board[i][j];
                if(curr != '.'){
                   if(!seen.add(curr + " found in row " + i)||
                     !seen.add(curr + " found in col" + j)||
                     !seen.add(curr + " found in box " + (i/3) +"-"+(j/3))){
                       return false;
                   } 
                }
            }
        }
        return true;
    }
}
​
// public boolean isValidSudoku(char[][] board) {
//         for(int i = 0;i < 9;i++){
//             boolean[] rowCheck = new boolean[9];
//             boolean[] colCheck = new boolean[9];
//             boolean[] boxCheck = new boolean[9];
//             for(int j = 0;j< 9;j++){
//                 if(board[i][j] == '.'){}
//                 else if(rowCheck[board[i][j] - '1']) return false;
//                 else rowCheck[board[i][j] - '1'] = true;
//                 if(board[j][i] == '.'){}
//                 else if(colCheck[board[j][i] - '1']) return false;
//                 else colCheck[board[j][i] - '1'] = true;
//                 int m = i/3*3 + j/3;
//                 int n = i%3*3 + j%3;
//                 if(board[m][n] == '.') {}
//                 else if(boxCheck[board[m][n] - '1']) return false;
//                 else boxCheck[board[m][n] - '1'] = true;
//             }
//         }
//         return true;
//     }
