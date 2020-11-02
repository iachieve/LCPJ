class Solution{
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
    }
    public int dfs(TreeNode root, int[] ans){
        if(root == null) return 0;
        int left = dfs(root.left, ans);
        int right = dfs(root.right, ans);
        ans[0] = Math.max(ans[0], left + right);
        return Math.max(left, right) + 1;
    }
}
​
