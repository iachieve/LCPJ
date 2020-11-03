class Solution {
    // 1    /   20
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0 ; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return helper(0, 0, inorder.length - 1, preorder, inorderMap);
    }
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> inorderMap){
        if(inStart > inEnd) return null;
        TreeNode curr = new TreeNode(preorder[preStart]);
        int inPivot = inorderMap.get(preorder[preStart]);
        curr.left = helper(preStart + 1, inStart, inPivot - 1, preorder, inorderMap);
        curr.right = helper(preStart + inPivot - inStart + 1, inPivot + 1, inEnd, preorder, inorderMap);
        return curr;
    }
}



// Runtime: 1 ms, faster than 98.38% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
// Memory Usage: 39.1 MB, less than 5.63% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = getValueToIndex(inorder);
        return helper(0, 0, inorder.length - 1, preorder, inorderMap);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> inorder) {
        if (preStart > preorder.length || inStart > inEnd) return null;

        TreeNode cur = new TreeNode(preorder[preStart]);
        int inPivot = inorder.get(preorder[preStart]);
        cur.left  = helper(preStart + 1, inStart, inPivot - 1, preorder, inorder);
        cur.right = helper(preStart + inPivot - inStart + 1, inPivot + 1, inEnd, preorder, inorder);
        return cur;
    }
    
      private Map<Integer, Integer> getValueToIndex(int[] inorder) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }
        return valueToIndex;
    }    
}



/*
// Runtime: 3 ms, faster than 53.56% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
// Memory Usage: 38.9 MB, less than 5.63% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length || inStart > inEnd) return null;

        TreeNode cur = new TreeNode(preorder[preStart]);
        
        // duplicate work happening here
        int inPivot = 0;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == preorder[preStart]){
                inPivot = i;
                break;
            }
        }
        
        cur.left  = helper(preStart + 1, inStart, inPivot - 1, preorder, inorder);
        cur.right = helper(preStart + inPivot - inStart + 1, inPivot + 1, inEnd, preorder, inorder);
        return cur;
    }
}

*/
