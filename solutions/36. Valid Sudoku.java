class Solution {
 public boolean isValidSudoku(char[][] board) {
 Set set = new HashSet();
StringBuilder rowSB = new StringBuilder();
StringBuilder colSB = new StringBuilder();
StringBuilder boxSB = new StringBuilder();

        for(int i = 0; i < 9; i++){
            for(int c = 0; c < 9; c++){
                rowSB.setLength(0);
                colSB.setLength(0);
                boxSB.setLength(0);
                char cur = board[i][c];
                if(cur != '.'){
                    if(!set.add(rowSB.append(cur).append("r").append(i).toString())
                      || !set.add(colSB.append(cur).append("c").append(c).toString())
                       || !set.add(boxSB.append(cur).append("sq").append(i/3).append(c/3).toString())
                      )
                        {
                        
                        return false;
                        }
            }}
        }
        return true;
    }
}
