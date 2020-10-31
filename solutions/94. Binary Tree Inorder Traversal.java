class Solution {
 
    // Left Parent Right
    // recursive 
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            res.addAll(inorderTraversal(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
            return res;
    }
    
    /*
    // iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        while(root!= null || !stack.isEmpty()){
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        
        return list;
    }
    */
}
