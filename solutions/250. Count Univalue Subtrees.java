class Solution {
    // O(n)
    public boolean isUni(TreeNode root) {
        // an empty tree is a unival tree by definition
        if (root == null) return true;
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        if (isUni(root.left) && isUni(root.right)) return true;
        return false;
    }
    // O(n^2)
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


// combining both function into one function
public class Solution {
    int count;
    
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }
    
    boolean helper(TreeNode root) {
        if (root == null) return true;
            
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        
        if (left && right && 
           (root.left == null || root.val == root.left.val) && 
           (root.right == null || root.val == root.right.val)) {
            count++;
            return true;
        }
        
        return false;
    }
}
