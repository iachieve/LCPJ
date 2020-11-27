class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet();
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, m, n, i, j, "s", sb); // start
                    String island = sb.toString();
                    if (!set.contains(island)) set.add(island);
                }
            }
        }
        return set.size();
    }
    
    private void dfs(int[][] grid, int m, int n, int i, int j, String dire, StringBuilder sb) {
        if (!isValid(m, n, i, j) || grid[i][j] != 1) return;
​
        grid[i][j] = 0;
        sb.append(dire);
        
        dfs(grid, m, n, i + 1, j, "d", sb); // down
        dfs(grid, m, n, i, j + 1, "r", sb); // right
        dfs(grid, m, n, i - 1, j, "u", sb); // up
        dfs(grid, m, n, i, j - 1, "l", sb); // left
        sb.append("e"); // end
    }
    
    private boolean isValid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
