class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = t.get(n-1).get(i);
        System.out.println(Arrays.toString(dp));
        
        // iterate over 
        for(int tRow = n-2; tRow >= 0; tRow--){
            for(int tCol = 0; tCol <= tRow; tCol++){
                int tColVal = dp[tCol];
                int tColNextVal = dp[tCol+1];
                int min = Math.min(tColVal, tColNextVal);
                int tVal = t.get(tRow).get(tCol);
                dp[tCol] = min + tVal;
                // System.out.println(Arrays.toString(dp));
            }
            System.out.println(Arrays.toString(dp));
​
        }
        return dp[0];
    }
}
