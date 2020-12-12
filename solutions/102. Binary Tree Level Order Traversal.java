class Solution {
public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
​
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
​
        while (!q.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
​
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) q.offer(currNode.left);
​
                if (currNode.right != null) q.offer(currNode.right);
            }
​
            levels.add(currLevel);
        }
​
        return levels;
    }
}
