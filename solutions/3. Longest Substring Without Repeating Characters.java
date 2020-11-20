class Solution {
    // 1    2   3   4   5   6   7   8   9   10
    // 1    2   3   4   5   6   
    public int lengthOfLongestSubstring(String s) {
      
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0, left = 0; right < s.length(); right ++){
            char c = s.charAt(right);
            if(map.containsKey(c)) left = Math.max(left, map.get(c));
            map.put(c, right + 1);
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
        
    }
}


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
