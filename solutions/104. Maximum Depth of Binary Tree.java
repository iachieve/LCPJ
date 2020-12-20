// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int depth = 0;
//         while (!queue.isEmpty()) {
//             int qSize = queue.size();
//             for (int i = 0; i < qSize; i++) {
//                 root = queue.poll();
//                 if (root.left != null) queue.add(root.left);
//                 if (root.right != null) queue.add(root.right);
//             }
//             depth++;
//         }
//         return depth;
//     }
// }
​
​
// recursive
class Solution {
     public int maxDepth(TreeNode root) {
         if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     }
}
​
// recursive
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
​
​
​
