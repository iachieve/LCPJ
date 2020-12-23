class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; ++i) inMap.put(in[i], i);
        return buildTree(pre, inMap, 0, in.length - 1, 0);
    }
    public TreeNode buildTree(int[] pre, Map<Integer, Integer> inMap, int inStart, int inEnd, int rootIndex) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[rootIndex]);
        int inMid = inMap.get(pre[rootIndex]);
        root.left = buildTree(pre, inMap, inStart, inMid - 1, rootIndex + 1);
        int leftTreeLen = inMid - inStart;
        root.right = buildTree(pre, inMap, inMid + 1, inEnd, rootIndex + leftTreeLen + 1);
        return root;
    }
}
