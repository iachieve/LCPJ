class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        List<String> notAllowed = new ArrayList<>(Arrays.asList(".", "", ".."));
        String[] paths = path.split("/");
        for(String p: paths){
            if(!stack.isEmpty() && p.equals("..")) stack.pop();
            else if(!notAllowed.contains(p)) stack.push(p);
        }
        
        return "/" + String.join("/", stack);
    }
}
