class Solution {
    public TreeNode buildTree(int[] in, int[] pos) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) inMap.put(in[i], i);
        return buildTree(pos, inMap, 0, in.length - 1, pos.length - 1);
    }
    public TreeNode buildTree(int[] pos, Map<Integer, Integer> inMap, int inStart, int inEnd, int rootIndex) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(pos[rootIndex]);
        int inMid = inMap.get(pos[rootIndex]);
        root.right = buildTree(pos, inMap, inMid + 1, inEnd, rootIndex - 1);
        int rightTreeLen = inEnd - inMid;
        root.left = buildTree(pos, inMap, inStart, inMid - 1, rootIndex - rightTreeLen - 1);
        return root;
    }
}
