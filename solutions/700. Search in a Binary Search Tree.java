/*
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
       while (root != null) {
            if (root.val == val) return root;
            else if (root.val > val) root = root.left;
           else root = root.right;
       }
        return null;
    }
}
*/
​
class Solution {
    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null || root.val == target) return root;
        if (target < root.val) return searchBST(root.left, target);
        else return searchBST(root.right, target);
    }
}
​
/*
 public TreeNode searchBST(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return root;
        }
        if (target < root.val) {
            return searchBST(root.left, target);
        }
        return searchBST(root.right, target);
    }
*/
