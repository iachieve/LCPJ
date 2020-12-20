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
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int depth = 0;
//         while (!queue.isEmpty()) {
//             int qSize = queue.size();
//             for (int i = 0; i < qSize; i++) {
//                 root = queue.poll();
//                 if (root.left != null) queue.add(root.left);
//                 if (root.right != null) queue.add(root.right);
//             }
//             depth++;
//         }
//         return depth;
//     }
// }

/*
// recursive
class Solution {
     public int maxDepth(TreeNode root) {
         if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     }
}
*/
// recursive
class Solution {
     public int maxDepth(Node root) {
        if (root == null) return 0;
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        stack.push(root);
        depths.add(1);
        int depth = 0;
        while (!stack.isEmpty()) {
            Node curr = stack.pollLast();
            int currDepth = depths.pollLast();
            if (curr != null) {
                depth = Math.max(depth, currDepth);
                stack.add(curr.right);
                depths.add(currDepth + 1);
                stack.add(curr.left);
                depths.add(currDepth + 1);
            }
        }
        return depth;
    }
}












