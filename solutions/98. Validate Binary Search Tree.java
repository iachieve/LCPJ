​
class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return isValidBST(root, null, null);
//     }
    
//     private boolean isValidBST(TreeNode root, Integer min, Integer max) {
//         if(root == null) return true;
//         if((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
//         return isValidBST(root.left, min, root.val) &&
//             isValidBST(root.right, root.val, max);
//     }
    
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;
​
        while (!stack.isEmpty() || root != null) {
          while (root != null) {
            stack.push(root);
            root = root.left;
          }
          root = stack.pop();
          if (root.val <= inorder) return false;
          inorder = root.val;
          root = root.right;
        }
        return true;
  }
}
