class Solution {
    public String simplifyPath(String path) {
        Stack stk = new Stack();
        String[] paths = path.split("/");
        
        for(String s: paths){
            if(!stk.isEmpty() && s.equals("..")) stk.pop();
            if(!s.isEmpty() && !s.equals(".") && !s.equals("..") && !s.equals(" ") ) stk.push(s);
            System.out.println(stk);
        }
        return  "/" + String.join("/", stk);
    }
}
