class Solution {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) inorderMap.put(inorder[i], i);
        index = postorder.length-1;
        return build(postorder, inorderMap, 0, postorder.length-1);
    }
    
    public TreeNode build(int[] postorder, Map<Integer, Integer> inorderMap, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(postorder[index--]);
        int pivot = inorderMap.get(root.val);
        root.right = build(postorder, inorderMap, pivot + 1, end);
        root.left = build(postorder, inorderMap, start, pivot - 1);
        return root;
    }
}
