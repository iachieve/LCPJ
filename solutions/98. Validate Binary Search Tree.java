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
​
// recursive solution
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    public boolean isValidBST(TreeNode node, Integer min, Integer max){
        if(node == null) return true;
        Integer val = node.val;
        if((min != null && node.val <= min) || (max != null && val >= max)) return false;
        return isValidBST(node.left, min, node.val) &&
            isValidBST(node.right, node.val, max);
        
    }
}
​
​
​
​
​
​
​
​
​
​
​
