class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() > 12) return ans;
        backtrack(s, 0, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(String s, int start, int len, List<String> temp, List<String> ans) {
        if(temp.size() > 4 || len > s.length()) return;
        if(temp.size() == 4 && len == s.length()) {
            // e.g. [255, 10, 244, 1] (after join)=> "255.10.244.1"
            ans.add(String.join(".", temp));
            return;
        }
        
        // Find split point
        for(int i = 1; i <= 3; i++) {
            if(start + i > s.length()) break;
            
            String str = s.substring(start, start + i);
            
            if(isValid(str)) {
                temp.add(str);
                
                backtrack(s, start + i, len + str.length(), temp, ans);
                
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) { // Valid: "0"Invalid: "01" "001"
        if(s.length() > 1 && s.startsWith("0")) return false;
        int n = Integer.valueOf(s);
        return n <= 255;
    }
}
