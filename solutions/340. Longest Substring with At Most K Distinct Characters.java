class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    
        int len = s.length(), left = 0, right = 0, max = 1;
        if(len * k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < len){
            map.put(s.charAt(right), right++);
            if(map.size() == k+1){
                int delIdx = Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                left = delIdx + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
