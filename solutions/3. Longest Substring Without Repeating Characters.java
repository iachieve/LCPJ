class Solution {
    // 1    2   3   4   5   6   7
    public int lengthOfLongestSubstring(String s) {
       int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0, left = 0; right < s.length(); right ++){
            char c = s.charAt(right);
            if(map.containsKey(c)) left = Math.max(left, map.get(c));
            map.put(c, right + 1);
            ans = Math.max(ans, right -left + 1);
        }
           
           
           
           return ans;
    }
}
