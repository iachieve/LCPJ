class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       //=================================================
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int qSize = q.size();
            for (int i = 0; i < qSize; ++i) {
                root = q.poll();
                layer.add(root.val);
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
            }
            res.add(layer);
        }
        return res;
        
        
        
        
       //=================================================
        
    }
}
