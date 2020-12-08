// class Solution {
//     public int numDecodings(String s) {
//         if(s == null || s.length() == 0) return 0;
//         int[] dp = new int[s.length() + 1];
//         dp[0] = 1;
//         dp[1] = s.charAt(0) == '0' ? 0 : 1;
//         for (int i = 2; i < dp.length; ++i) {
//             if(s.charAt(i-1) != '0') dp[i] += dp[i-1];
//             int twoDigit = Integer.valueOf(s.substring(i-2, i));
//             if(twoDigit >= 10 && twoDigit <= 26) dp[i] += dp[i-2];
//         }
//         return dp[s.length()];
//     }
// }

// class Solution {

//     HashMap<Integer, Integer> memo = new HashMap<>();
//     private int recursiveWithMemo(int index, String str) {

        
//         // Return 1 for success.
//         if (index == str.length()) {
//             return 1;
//         }

//         // If the string starts with a zero, it can't be decoded
//         if (str.charAt(index) == '0') {
//             return 0;
//         }

//         if (index == str.length()-1) {
//             return 1;
//         }

//         // Memoization is needed since we might encounter the same sub-string.
//         if (memo.containsKey(index)) {
//             return memo.get(index);
//         }

//         int ans = recursiveWithMemo(index+1, str);
//         if (Integer.parseInt(str.substring(index, index+2)) <= 26) {
//              ans += recursiveWithMemo(index+2, str);
//          }

//         // Save for memoization
//         memo.put(index, ans);

//         return ans;
//     }
//     public int numDecodings(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         return recursiveWithMemo(0, s);
//     }
// }


class Solution {
    
     public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecoding(s, 0, dp);
    }

    private int numDecoding(String s, int decodePointer, int[] dp) {
        if (decodePointer >= s.length()) {
            return 1; // "" is a valid decomposition
        }

        // Subproblem already solved and has a value
        if (dp[decodePointer] > -1) {
            return dp[decodePointer];
        }

        int totalDecompositions = 0;
        for (int i = 1; i <= 2; i++) {
            if (decodePointer + i <= s.length()) {
                String snippet = s.substring(decodePointer, decodePointer + i);
                if (isValid(snippet)) {
                    totalDecompositions += numDecoding(s, decodePointer + i, dp);
                }
            }
        }

        // Record subproblem answer to decompositions from (decodePointer)...(s.length - 1)
        dp[decodePointer] = totalDecompositions;

        return dp[decodePointer];
    }

    private boolean isValid(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return false;
        }

        int value = Integer.parseInt(s);

        return value >= 1 && value <= 26;
    }
}
