class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        int open = 0, balance = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                open++;
                balance++;
            }else if (c == ')') {
                if (balance == 0) continue;
                balance--;
            }
            res.append(c);
        }
        
        StringBuilder result = new StringBuilder();
        int openToKeep = open - balance;
        for (int i = 0; i < res.length(); ++i) {
            char c = res.charAt(i);
            if (c == '(' && --openToKeep < 0) continue;
            result.append(c);
        }
        return result.toString();
    }
}
