        if (decodePointer >= s.length()) {
            return 1; // "" is a valid decomposition
        }
​
        // Subproblem already solved and has a value
        if (dp[decodePointer] > -1) {
            return dp[decodePointer];
        }
​
        int totalDecompositions = 0;
        for (int i = 1; i <= 2; i++) {
            if (decodePointer + i <= s.length()) {
                String snippet = s.substring(decodePointer, decodePointer + i);
                if (isValid(snippet)) {
                    totalDecompositions += numDecoding(s, decodePointer + i, dp);
                }
            }
        }
​
        // Record subproblem answer to decompositions from (decodePointer)...(s.length - 1)
        dp[decodePointer] = totalDecompositions;
​
        return dp[decodePointer];
    }
​
    private boolean isValid(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return false;
        }
​
        int value = Integer.parseInt(s);
​
        return value >= 1 && value <= 26;
    }
}
​
​
