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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<Integer>();
        toList(root,sorted);
        return balance(0,sorted.size()-1,sorted);
    }
    private void toList(TreeNode node, List<Integer> sorted) {
        if (node == null) return;
        toList(node.left,sorted);
        sorted.add(node.val);
        toList(node.right,sorted);
    }
    private TreeNode balance(int l, int r, List<Integer> sorted) {
        if (l>r) return null;
        int mid = (l+r)/2;
        TreeNode n = new TreeNode(sorted.get(mid));
        n.left = balance(l,mid-1,sorted);
        n.right = balance(mid+1,r,sorted);
        return n;
    }
}
