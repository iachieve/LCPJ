class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int sr = 0, er = matrix.length-1, sc= 0, ec = matrix[0].length-1;
        while(sr <= er && sc <= ec){
            for(int i= sc  ; i <= ec; i++) res.add(matrix[sr][i]);
            for(int i= sr+1; i <=  er; i++) res.add(matrix[i][ec]);
            for(int i= ec-1; i >= sc ; i--) {
                if(sr == er) break;
                res.add(matrix[er][i]);
            }
            for(int i= er-1; i >= sr+1 ; i--) {
                if(sc == ec) break;
                res.add(matrix[i][sc]);
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
        return res;
    }
}
