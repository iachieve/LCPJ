class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> dic = new HashMap<>(), window = new HashMap<>();
        for(char c: t.toCharArray()) dic.put(c, dic.getOrDefault(c, 0)+1);
        
        int left = 0, right = 0, min = Integer.MAX_VALUE, formed = 0;
        String res = "";
        
        while(right < s.length()){
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            if(dic.containsKey(rightChar) && window.get(rightChar).intValue() == dic.get(rightChar).intValue())
                formed++;
            
            while(formed == dic.size() && left <= right){
                char leftChar = s.charAt(left);
                int currWindowSize = right - left + 1;
                if(currWindowSize < min){
                    min = currWindowSize;
                    res = s.substring(left, right + 1);
                }
                window.put(leftChar, window.get(leftChar) - 1);
                if(dic.containsKey(leftChar) && window.get(leftChar).intValue() < dic.get(leftChar).intValue())
                    formed--;
                left++;
            }
            right++;
        }
        return res;
    }
}
