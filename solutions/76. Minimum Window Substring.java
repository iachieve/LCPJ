class Solution {
    public String minWindow(String s, String t) {
      Map<Character, Integer> dicT = new HashMap<>();
        for(char c: t.toCharArray()) dicT.put(c, dicT.getOrDefault(c, 0) + 1);
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, tMapSize = dicT.size(), min = Integer.MAX_VALUE, formed = 0;
        String result = "";
​
        while (right < s.length()) {
            // expand
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
​
            if (dicT.containsKey(rightChar)) {
                if (dicT.get(rightChar).intValue() == window.get(rightChar).intValue()) {
                    formed++;
                }
            }
​
            while (formed == tMapSize && left <= right) { // contraction
                char leftChar = s.charAt(left);
                int windowSize = right - left + 1;
​
                if (windowSize < min) {
                    min = windowSize;
                    result = s.substring(left, right + 1);
                }
​
                window.put(leftChar, window.get(leftChar) - 1);
​
                boolean isLeftCharRequire = dicT.containsKey(leftChar);
                if (isLeftCharRequire) {
                    if (window.get(leftChar).intValue() < dicT.get(leftChar).intValue()) {
                        formed--;
                    }
                }
​
                left++;
            }
​
            right++;
        }
​
        return result;
    }
}
