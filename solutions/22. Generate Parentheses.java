class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
​
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if(close > open || open > max || close > max) return;
​
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
​
        
        backtrack(ans, cur.append("("), open+1, close, max);
        cur.setLength(cur.length()-1);
​
​
        backtrack(ans, cur.append(")"), open, close+1, max);
        cur.setLength(cur.length()-1);
    
    }
}
