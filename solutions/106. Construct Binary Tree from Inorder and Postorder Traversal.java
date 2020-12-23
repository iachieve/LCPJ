class Solution {
public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inOrderMap.put(inorder[i], i);
        return buildTree(postorder, inOrderMap, 0, inorder.length-1, postorder.length - 1);
    }
​
    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> inOrderMap, int inStart, int inEnd, int rootIndex) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[rootIndex]);
        int inOrderMidIndex = inOrderMap.get(postorder[rootIndex]);
        
        root.right = buildTree(postorder, inOrderMap, inOrderMidIndex+1, inEnd, rootIndex-1);
        
        int rightTreeLength = inEnd - inOrderMidIndex;
        root.left = buildTree(postorder, inOrderMap, inStart, inOrderMidIndex-1, rootIndex-rightTreeLength-1);
        
        return root;
    }
}
