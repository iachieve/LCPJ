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
  public boolean hasPathSum(TreeNode node, int targetSum) {
    if (node == null) {
      return false;
    }
​
    /*
     * If we are at a leaf node & the subtraction of the value of this node from the
     * running sum (we are reducing at each node) brings us to 0, this node
     * completes the path
     */
    boolean isLeaf = node.left == null && node.right == null;
    if (isLeaf && targetSum - node.val == 0) {
      return true;
    }
​
    /*
     * Reduce the subproblem, does the left subtree have a path or the right
     * subtree?
     * 
     * We "add" this node to the path by taking it's value from the target sum.
     * 
     * Path "completion" is if we can reach 0 exactly (all items add up to
     * 'targetSum').
     * 
     * So: 1 + 2 + 3 = 6
     * 
     * Is the same as: 0 = 6 - 1 - 2 - 3
     */
    return hasPathSum(node.left, targetSum - node.val) ||
      hasPathSum(node.right, targetSum - node.val);
  }
}


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
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        nodeStack.push(root);
        sumStack.push(sum - root.val);
        TreeNode node;
        int currSum;
        while ( !nodeStack.isEmpty() ) {
            node = nodeStack.pollLast();
            currSum = sumStack.pollLast();
            if (node.right == null && node.left == null && currSum == 0) return true;
            
            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currSum - node.right.val);
            }
            
            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currSum - node.left.val);
            }
        }
        return false;
    }
}














