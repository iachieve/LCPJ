class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(len < 3) return len;
        int left = 0, right = 0, maxLen = 2;
        Map<Character, Integer> map = new HashMap<>();
        while(right < len){
            map.put(s.charAt(right), right++);
            if(map.size() == 3){
                int delIdx = Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                left = delIdx + 1;
            }
                maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
