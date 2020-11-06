class Solution {
    // 3    10
    public TreeNode balanceBST(TreeNode root) {
       List<Integer> sorted = new ArrayList<>();
        toList(root, sorted);
        return balanceBST(0, sorted.size() - 1, sorted);
    }
    
    private void toList(TreeNode node, List<Integer> sorted){
        if(node == null) return;
        toList(node.left, sorted);
        sorted.add(node.val);
        toList(node.right, sorted);
    }
    
    private TreeNode balanceBST(int l, int r, List<Integer> sorted){
        if(l > r) return null;
        int mid = (l+r) / 2;
        TreeNode node = new TreeNode(sorted.get(mid));
        node.left = balanceBST(l, mid-1, sorted);
        node.right = balanceBST(mid+1, r, sorted);
        return node;
    }
   
}
