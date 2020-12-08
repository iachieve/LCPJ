class Solution {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
​
        if (len1 * len2 == 0) return len1 + len2;
​
        int [][] dp = new int[len1 + 1][len2 + 1];
​
        for (int row = 0; row < len1 + 1; row++) dp[row][0] = row;
        for (int col = 0; col < len2 + 1; col++) dp[0][col] = col;
​
        for (int row = 1; row < len1 + 1; row++) {
            for (int col = 1; col < len2 + 1; col++) {
                int top = dp[row - 1][col] + 1;
                int left = dp[row][col - 1] + 1;
                int leftDown = dp[row - 1][col - 1];
                if (word1.charAt(row - 1) != word2.charAt(col - 1)) leftDown += 1;
                dp[row][col] = Math.min(left, Math.min(top, leftDown));
            }
        }
        return dp[len1][len2];
    }
}
​
