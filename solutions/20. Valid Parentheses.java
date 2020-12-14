class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpenTags = new HashMap<>(){{
           put(')', '('); 
            put(']', '[');
            put('}', '{');
        }};
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(closeToOpenTags.containsKey(c)){ /// closing tag 
                if(stack.isEmpty()) return false;
                if(stack.pop() != closeToOpenTags.get(c)) return false;
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
