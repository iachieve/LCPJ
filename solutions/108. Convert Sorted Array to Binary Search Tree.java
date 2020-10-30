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
    public TreeNode sortedArrayToBST(int[] nums) {
            return buildMinHeighBST(nums, 0, nums.length);
    }
    private TreeNode buildMinHeighBST(int[] nums, int left, int right) {
    if (left >= right) {
      return null;
    }
​
    /*
     * Pull out the value from the middle item and create a new node with this value
     */
    int middleIndex = left + ((right - left) / 2);
    TreeNode newNode = new TreeNode(nums[middleIndex]);
​
    /*
     * Set the left and right subtrees of this new node using this same function.
     * Each call will root the tree built at the "most balanced" node, which is the
     * middle of the sorted sub-section (between left & right)
     */
    newNode.left = buildMinHeighBST(nums, left, middleIndex);
    newNode.right = buildMinHeighBST(nums, middleIndex + 1, right);
​
    return newNode;
  }
}
​
