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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.push(root);
        while (!que.isEmpty()) {
           root = que.pop();
            res.addFirst(root.val);
            if (root.left != null) que.push(root.left);
            if (root.right != null) que.push(root.right);;
        }
        return res;
    }
}
