class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val){
                res = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return res;
    }
}
​
/*
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && p.val == prev) return root;
            prev = root.val;
            root = root.right;
        }
        return null;
    }
}
*/
