/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int getHeight(TreeNode root){
        if(root==null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    
    public boolean isBalanced(TreeNode root) {
       if(root == null) return true;
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);
        if(Math.abs(lH-rH) >1) return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
}
