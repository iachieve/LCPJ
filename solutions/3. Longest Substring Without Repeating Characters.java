public class Solution {
    
        // Runtime: 7 ms, faster than 39.04% of Java online submissions for Longest Substring Without Repeating Characters.
        // Memory Usage: 39.9 MB, less than 15.56% of Java online submissions for Longest Substring Without Repeating Characters.
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, left = 0, right = 0;
        while (left < s.length() && right < s.length()){
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                ans = Math.max(ans, right - left);
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }
}
​
​
// correct but time lime exceed with long strings
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                if(allUnique(s, i, j)) ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
    
    boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}*/
