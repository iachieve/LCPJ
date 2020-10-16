class Solution {
    public int longestPalindrome(String s) {
        Set<Character> unmatchingChars = new HashSet<Character>();
        int matches = 0;
        for(char c: s.toCharArray()){
            if(unmatchingChars.contains(c)){
                matches++;
                unmatchingChars.remove(c);
            }else{
                unmatchingChars.add(c);
            }
        }
        return (matches * 2) + (unmatchingChars.isEmpty() ? 0 : 1);
    }
}
