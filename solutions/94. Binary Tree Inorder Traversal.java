class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
