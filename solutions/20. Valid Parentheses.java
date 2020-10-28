class Solution {
    public boolean isValid(String s) {
        
        Map<Character, Character> closeToOpenMap = new HashMap<>(){{
                                        put(')', '(');
                                        put('}','{');
                                        put(']','[');
                                    }};
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(closeToOpenMap.containsKey(c)){
                if(stack.isEmpty()) return false;
                char correctOpeningTag = closeToOpenMap.get(c);
                if(stack.pop() != correctOpeningTag) return false;
            }else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
​
