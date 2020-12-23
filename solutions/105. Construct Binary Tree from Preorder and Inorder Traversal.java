class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) inMap.put(inorder[i], i);
        return buildTree(preorder, inMap, 0, inorder.length - 1, 0);
    }
    public TreeNode buildTree(int[] pre, Map<Integer, Integer> inMap, int inStart, int inEnd, int rootIndex) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[rootIndex]);
        int inMid = inMap.get(pre[rootIndex]);
        root.left = buildTree(pre, inMap, inStart, inMid - 1, rootIndex + 1);
        int leftTreeLength = inMid - inStart;
        root.right = buildTree(pre, inMap, inMid + 1, inEnd, rootIndex + leftTreeLength + 1);
        return root;
    }
}
