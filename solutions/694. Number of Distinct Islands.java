class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int rowCount = grid.length, colCount = grid[0].length;
        for(int i = 0; i < rowCount; ++i){
            for(int j = 0; j < colCount; ++j){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, rowCount, colCount, i, j, "s", sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, int rowCount,int colCount,int i, int j, String dir, StringBuilder sb){
        if(i < 0 || i >= rowCount || j < 0 || j >= colCount || grid[i][j] == 0) return;
        grid[i][j] = 0;
        
        sb.append(dir);
       
        
        dfs(grid, rowCount, colCount, i + 1, j, "d", sb); // down
        dfs(grid, rowCount, colCount, i - 1, j, "u", sb); // up
        
        dfs(grid, rowCount, colCount, i, j + 1, "r", sb); // right
        
        dfs(grid, rowCount, colCount, i, j - 1, "l", sb); // left
        
        
       
       
        
        
         sb.append("e");
    }
}
