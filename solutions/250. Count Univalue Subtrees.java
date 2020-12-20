class Solution {
    public boolean isUni(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        if (isUni(root.left) && isUni(root.right)) return true;
        return false;
    }
    
    public int count(TreeNode root) {
        if (root == null) return 0;
        int totalCount = count(root.left) + count(root.right);
        if (isUni(root)) totalCount+=1;
            return totalCount;
    }
            
    public int countUnivalSubtrees(TreeNode root) {
        return count(root);
    }
}
