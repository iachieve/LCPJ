/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 
 Input:
           1
          / \
         2   3
            / \
           4   5
                \
                 6
Output: false
Explanation: Breaks balance at root, |1 - 3| = 2 > 1.
| Node{i} | left sub height | right sub height |
|    1    |        1        |         3        |
|    2    |        0        |         0        |
|    3    |        1        |         2        |
|    4    |        0        |         0        |
|    5    |        0        |         1        |
|    6    |        0        |         0        |
 
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
