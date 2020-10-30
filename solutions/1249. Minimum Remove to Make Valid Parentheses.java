class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indices = new Stack<>();
        boolean[] removed = new boolean[s.length()];
        StringBuilder modified = new StringBuilder();
​
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '('){
                indices.push(i);
            }else if(curr == ')'){
                if(indices.isEmpty()){
                    removed[i] = true;
                }else{
                    indices.pop();
                }
            }
        }
​
        while(!indices.isEmpty()){
            removed[indices.peek()] = true;
            indices.pop();
        }
        
        for(int i = 0; i < s.length(); i++){
            if(!removed[i]){
                modified.append(s.charAt(i));
            }
        }
        return modified.toString();
    }
    
}
