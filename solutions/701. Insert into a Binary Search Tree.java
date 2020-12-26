/*
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            if (root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);
        }
        else if (root.val < val) {
            if (root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right, val);
        }
        return root;
    }
*/
​
/*
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
*/
​
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
         TreeNode node = root;
        while (node != null) {
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }else node = node.right;
            }else{
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }else node = node.left;
            }
        }
        return new TreeNode(val);
    }
}
​
​
​
​
​
