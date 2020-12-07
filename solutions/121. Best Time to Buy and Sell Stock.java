class Solution {
    // we can rephrase the this question to be: 
    // What the max difference between two elements in array of integers.
   
    
    
    
    
    // Time complexity : O(n). Only a single pass is needed.
    // Space complexity : O(1). Only two variables are used.
    
    /*
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for(int n: prices){
            min = Math.min(min, n);
            max = Math.max(max, n - min);
        }
        return max;
    }
    */
    
    // tabulation
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int minDay = prices[0];
        
        for (int i = 1; i < prices.length; ++i ) {
            int price = prices[i];
            minDay = Math.min(minDay, price);
            dp[i] = Math.max(dp[i-1], price - minDay);
        }
        return dp[dp.length - 1];
    }
}
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
