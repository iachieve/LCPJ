//         return wordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
//     }
//     private boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] memo) {
        
//         if (start == s.length()) return true;
//         if (memo[start] != null) {
//                 // System.out.println(Arrays.toString(memo));
//                 return memo[start];
//             }
        
//         for (int end = start + 1; end <= s.length(); ++end){
//             String subWord = s.substring(start, end);
//             // System.out.println("start: " + start + ", end: " + end + ", subWord: "+ subWord);
//                 if (wordDict.contains(s.substring(start, end)) && 
//                     wordBreak(s, wordDict, end, memo)) {
​
//                     // System.out.println("=> found: " + subWord + " in dict.");
//                     return memo[start] = true;
//                 }    
//              // System.out.println("XX didn't found: " + subWord + " in dict.");
//         }
//         return memo[start] = false;
//     }
// }
​
​
​
​
/*
Approach 4: Using Dynamic Programming
Runtime: 6 ms, faster than 61.65% of Java online submissions for Word Break.
Memory Usage: 40.1 MB, less than 5.15% of Java online submissions for Word Break.
*/
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
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
