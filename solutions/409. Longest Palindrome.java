class Solution {
    public int longestPalindrome(String s) {
        
         // ********** Hash Table Solution **********
        /*
        * Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Palindrome.
        * Memory Usage: 37.2 MB, less than 16.70% of Java online submissions for Longest Palindrome.
        */
        
        
        
        
        
        // ********** Integer Array Solution **********
        /*
        * Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Palindrome.
        * Memory Usage: 37.2 MB, less than 16.70% of Java online submissions for Longest Palindrome.
        */
        int result = 0;
        int[] counts = new int[128];
        for(char c: s.toCharArray()) counts[c]++;
        for(Integer cc: counts){
            result += cc / 2 * 2;
            if(result % 2 == 0 && cc % 2 == 1) result += 1;
        }
        return result;
        
        
        // ***** HashSet Solution *********
        /*
        * Runtime: 4 ms, faster than 55.85% of Java online submissions for Longest Palindrome.
        * Memory Usage: 38.6 MB, less than 16.70% of Java online submissions for Longest Palindrome.
        */
        // Set<Character> unmatchingChars = new HashSet<Character>();
        // int matches = 0;
        // for(char c: s.toCharArray()){
        //     if(unmatchingChars.contains(c)){
        //         matches++;
        //         unmatchingChars.remove(c);
        //     }else{
        //         unmatchingChars.add(c);
        //     }
        // }
        // return (matches * 2) + (unmatchingChars.isEmpty() ? 0 : 1);
    }
}
