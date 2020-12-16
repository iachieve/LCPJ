class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c: S.toCharArray()) {
            if (c == '('){
                stack.push(c);
            }else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else if (c == ')'){
                stack.push(c);
            }
        }
        return stack.size();
    }
}
