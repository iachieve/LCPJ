// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
// Memory Usage: 35.9 MB, less than 42.10% of Java online submissions for Unique Paths.
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; ++row){
            for (int col = 0; col < n; ++col) {
                if(row == 0 || col == 0) dp[row][col] = 1;
                else dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        return dp[m-1][n-1];
    }
}
