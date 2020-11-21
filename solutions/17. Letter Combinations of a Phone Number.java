class Solution {
    
    private String getLetters(char ch) {
        return switch (ch) {
            case '2' -> "abc";
            case '3' -> "def";
            case '4' -> "ghi";
            case '5' -> "jkl";
            case '6' -> "mno";
            case '7' -> "pqrs";
            case '8' -> "tuv";
            case '9' -> "wxyz";
            default -> "";
        };
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }
​
     private void backtrack(String digits, int start, StringBuilder cur, List<String> ans) {
        if (cur.length() == digits.length()) {
            ans.add(cur.toString());
            return;
        }
​
        for (int i = start; i < digits.length(); i++) {
            String letters = getLetters(digits.charAt(i));
​
            for (int j = 0; j < letters.length(); j++) {
                cur.append(letters.charAt(j));
                backtrack(digits, i + 1, cur, ans);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
