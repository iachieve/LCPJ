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


class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int pp = postorder.length - 1;
        int ip = inorder.length - 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;
        TreeNode prev = null;
        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) { 
                prev.left = newNode;
            } else {
                TreeNode currTop = stack.pop();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }
        return root;
    }
}
